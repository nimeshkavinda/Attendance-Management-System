/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams.models;

/**
 *
 * @author Nimesh
 */
public class LectureHall {
    
    private String lecturehall;
    private String hallsize;
    private String module;

    public LectureHall(String lecturehall, String hallsize, String module) {
        this.lecturehall = lecturehall;
        this.hallsize = hallsize;
        this.module = module;
    }

    public String getLecturehall() {
        return lecturehall;
    }

    public String getHallsize() {
        return hallsize;
    }

    public String getModule() {
        return module;
    }
    
    
    
}
