package com.example.demo.model;

import javax.persistence.*;

@Entity(name = "testmodel")
@Table(name = "TEST")
public class TestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @SequenceGenerator(name = "generator1", sequenceName = "SEQ", allocationSize = 1)
    @Column(name = "QUESTION_ID", nullable = false, unique = true)
    private int question_id;
    @Column(name = "QUESTION")
    private String question;
    @Column(name = "OPTION_A")
    private String option_A;
    @Column(name = "OPTION_B")
    private String option_B;
    @Column(name = "OPTION_C")
    private String option_C;
    @Column(name = "OPTION_D")
    private String option_D;
    @Column(name = "OPTION_E")
    private String option_E;


    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public String getOption_A() {
        return option_A;
    }

    public void setOption_A(String option_A) {
        this.option_A = option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public void setOption_B(String option_B) {
        this.option_B = option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public void setOption_C(String option_C) {
        this.option_C = option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    public void setOption_D(String option_D) {
        this.option_D = option_D;
    }

    public String getOption_E() {
        return option_E;
    }

    public void setOption_E(String option_E) {
        this.option_E = option_E;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "\"question_id\":" + "\"" + question_id + "\"" +
//                "\"question\":" + "\"" + question + "\"" +
//                "\"option_A\":" + "\"" + option_A + "\"" +
//                "\"option_B\":" + "\"" + option_B + "\"" +
//                "\"option_C\":" + "\"" + option_C + "\"" +
//                "\"option_D\":" + "\"" + option_D + "\"" +
//                "\"option_E\":" + "\"" + option_E + "\"" +
//                '}';
//    }
}