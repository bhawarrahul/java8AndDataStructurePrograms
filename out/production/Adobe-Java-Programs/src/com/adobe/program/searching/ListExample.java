package com.adobe.program.searching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Policy {
    private String funderId;

    public Policy(String fund) {
        this.funderId =fund;
    }
    public String getFunderId() {
        return funderId;
    }

    public void setFunderId(String funderId) {
        this.funderId = funderId;
    }
}

public class ListExample {
    public static void main(String[] args) {
        List<Policy> example = new ArrayList<>();
        example.add(new Policy("1"));
        example.add(new Policy("2"));
        example.add(new Policy("0"));

        List<String> funderIdList= example.stream()
                .map(policy -> policy.getFunderId().toString())
                .filter(fund->Long.valueOf(fund)>0)
                .collect(Collectors.toList());
        System.out.println(funderIdList);
    }
}
