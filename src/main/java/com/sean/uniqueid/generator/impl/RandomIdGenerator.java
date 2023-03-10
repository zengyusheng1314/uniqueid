package com.sean.uniqueid.generator.impl;

import com.google.common.annotations.VisibleForTesting;
import com.sean.uniqueid.generator.LogTraceIdGenerator;
import com.sean.uniqueid.generator.excetiopn.IdGenerationFailureException;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


/**
 * Id生成器，用于生成随机Id
 * 这个类生成的id不是绝对唯一的，但重复的概率非常低
 * 格式：{主机名截取ip最后一个点后面的主机号}-{时间戳}-{8位随机数（包含数字大小写字母）}
 *
 * @author zengyusheng
 * @date 2023/3/9 16:59
 */

public class RandomIdGenerator implements LogTraceIdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastFieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("id生成失败", e);
        }

        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private String getLastFieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("未知的主机名");
        }
        substrOfHostName = getLastSubstrSplitByDot(hostName);
        return substrOfHostName;
    }


    private String getLastSubstrSplitByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("主机名不能为空");
        }
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }


    private String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("生成长度应大于等于1，实际为" + length);
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}
