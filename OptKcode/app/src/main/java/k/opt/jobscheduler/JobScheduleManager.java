package k.opt.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

/**
 * @author :key.guan
 * @package :k.opt.jobscheduler
 * @date : 2017/6/5
 * Description:
 * Copyright (c) 2017. DJI All Rights Reserved.
 */

class JobScheduleManager {
    private static final JobScheduleManager ourInstance = new JobScheduleManager();
    private Context mCtx;
    private JobScheduler mJS;

    static JobScheduleManager getInstance() {
        return ourInstance;
    }
    public void init(Context ctx){
        mCtx = ctx;
        mJS = (JobScheduler)mCtx.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }
    public boolean addJobScheduleTask(int task_id){
        JobInfo.Builder builder = new JobInfo.Builder(task_id, new ComponentName("k.opt"), JobSchedulerService.class.getName());
        switch (task_id){
            case 1:
                builder.setPeriodic(1000);
                break;
            case 2:
                builder.setPersisted(false);
                break;
            default:
        }
       if (mJS != null){
           return mJS.schedule(builder.build()) > 0;
       }else {
           return false;
       }
    }


    private JobScheduleManager() {
    }
}
