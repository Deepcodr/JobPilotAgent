package com.deepcodr.JobPilot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    public String title;
    public String location;
    public String snippet;
    public String salary;
    public String source;
    public String type;
    public String link;
    public String company;
    public String updated;
    public String id;
}
