package com.hollysys.hiadsp.uaa.dto;

public class ResourcesofCrawl {
    private float cpuP;// cpu使用率
    private float memoryP;// 内存使用率
    private float memoryUsed;// 使用内存大小
    private float diskSize;// 所在盘符的硬盘大小
    private float diskUnused;// 所在盘符的硬盘剩余空间
    /**
     * @return the cpuP
     */
    public float getCpuP() {
        return cpuP;
    }
    /**
     * @param cpuP the cpuP to set
     */
    public void setCpuP(float cpuP) {
        this.cpuP = cpuP;
    }
    /**
     * @return the memoryP
     */
    public float getMemoryP() {
        return memoryP;
    }
    /**
     * @param memoryP the memoryP to set
     */
    public void setMemoryP(float memoryP) {
        this.memoryP = memoryP;
    }
    /**
     * @return the memoryUsed
     */
    public float getMemoryUsed() {
        return memoryUsed;
    }
    /**
     * @param memoryUsed the memoryUsed to set
     */
    public void setMemoryUsed(float memoryUsed) {
        this.memoryUsed = memoryUsed;
    }
    /**
     * @return the diskSize
     */
    public float getDiskSize() {
        return diskSize;
    }
    /**
     * @param diskSize the diskSize to set
     */
    public void setDiskSize(float diskSize) {
        this.diskSize = diskSize;
    }
    /**
     * @return the diskUnused
     */
    public float getDiskUnused() {
        return diskUnused;
    }
    /**
     * @param diskUnused the diskUnused to set
     */
    public void setDiskUnused(float diskUnused) {
        this.diskUnused = diskUnused;
    }
    
}
