package com.software.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ip;
    private String name;
    private String memory;
    private String disk;
    private String processor;
    private String location;
    @Column(name = "operating_system")
    private String operatingSystem;
    @JsonIgnoreProperties("server")
    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL)
    private List<Application> applications;

}
