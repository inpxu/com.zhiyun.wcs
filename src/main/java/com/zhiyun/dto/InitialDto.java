package com.zhiyun.dto;

import java.io.Serializable;

public class InitialDto implements Serializable {
    private static final long serialVersionUID = 5177352138883271254L;

    private RunningTaskDto runningTask;
    private WaittingTaskDto waittingTask;

    public RunningTaskDto getRunningTask() {
        return runningTask;
    }

    public void setRunningTask(RunningTaskDto runningTask) {
        this.runningTask = runningTask;
    }

    public WaittingTaskDto getWaittingTask() {
        return waittingTask;
    }

    public void setWaittingTask(WaittingTaskDto waittingTask) {
        this.waittingTask = waittingTask;
    }
}
