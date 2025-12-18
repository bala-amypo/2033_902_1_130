package com.example.demo.entity;
public class FraudRule{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleCode;
    private String description;
    private String ruleType;
    private Boolean active;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getRuleCode(){
        return ruleCode;
    }
    public void setRuleCode(String ruleCode){
        this.ruleCode=ruleCode;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getRuleType(){
        return ruleType;
    }
    public void setRuleType(String ruleType){
        this.ruleType=ruleType;
    }
    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }

    public FraudRule(Long id,String ruleCode,String description,String ruleType,Boolean active){
        this.id=id;
        this.ruleCode=ruleCode;
        this.description=description;
        this.ruleType=ruleType;
        this.active=active;
    }
    public FraudRule(){
        
    }
}