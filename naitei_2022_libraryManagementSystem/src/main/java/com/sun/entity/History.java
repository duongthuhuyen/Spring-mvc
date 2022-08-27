package com.sun.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "histories")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "received_date")
    private LocalDateTime receivedDate;
    @Column(name = "borrow_date")
    private LocalDateTime borrowDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private EStatus status;
    public enum EStatus{
        REQUEST,ACCEPT,REJECT;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public History(LocalDateTime receivedDate, LocalDateTime borrowDate, EStatus status, User user) {
        this.receivedDate = receivedDate;
        this.borrowDate = borrowDate;
        this.status = status;
        this.user = user;
    }

    public History(LocalDateTime receivedDate, EStatus status, User user) {
        this.receivedDate = receivedDate;
        this.status = status;
        this.user = user;
    }
}
