package com.dailycodebuffer.user.ValueObjects;

import com.dailycodebuffer.user.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
    private User user;
    private Department department;
}
