package com.source2sea.recruitment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;

    private Integer clientAge;
    private String clientType;

    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public Integer getClientAge() {
        return clientAge;
    }

    public String getClientType() {
        return clientType;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return movieName.equals(that.movieName) && clientAge.equals(that.clientAge) && clientType.equals(that.clientType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, clientAge, clientType);
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", clientAge=" + clientAge +
                ", clientType='" + clientType + '\'' +
                '}';
    }
}
