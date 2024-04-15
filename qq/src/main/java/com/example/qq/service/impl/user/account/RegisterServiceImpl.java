package com.example.qq.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.qq.mapper.UserMapper;
import com.example.qq.pojo.User;
import com.example.qq.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            map.put("error_message", "课程名称不能为空");
            return map;
        }
        if (password == null || confirmedPassword == null) {
            map.put("error_message", "教师教室不能为空");
            return map;
        }

        username = username.trim();
        if (username.length() == 0) {
            map.put("error_message", "课程名称不能为空");
            return map;
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "教师教室不能为空");
            return map;
        }

        if (username.length() > 100) {
            map.put("error_message", "课程名称长度不能大于100");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "教师教室长度不能大于100");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "课程名称已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = confirmedPassword;
        User user = new User(null, username, password, photo);
        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}

