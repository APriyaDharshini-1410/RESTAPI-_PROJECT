package com.examly.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String topic;

    public Speaker() {}

    public Speaker(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public Object getExperience() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getExperience'");
    }

    public void setExperience(Object experience) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setExperience'");
    }
}
