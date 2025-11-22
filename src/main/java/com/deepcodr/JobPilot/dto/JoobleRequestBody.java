package com.deepcodr.JobPilot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoobleRequestBody {
    public String keywords;
    public String location;
}
