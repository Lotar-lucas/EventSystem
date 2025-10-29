package lotar.com.EventSystem.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_block")
public class Block {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant startTime;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant endTime;

  public Block() {};

  public Block(Integer id, Instant startTime, Instant endTime) {
    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public void setStartTime(Instant startTime) {
    this.startTime = startTime;
  }

  public Instant getEndTime() {
    return endTime;
  }

  public void setEndTime(Instant endTime) {
    this.endTime = endTime;
  }
}
