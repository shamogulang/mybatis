package cn.yishijie.mybatis.domain.protag;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Table(name = "prod_tag")
public class ProdTagEntity {

  // 加了之后，使用mapper tk的insert方法可以返回主键id
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String value;
  private String name;
  private Byte type;
  private Timestamp createTime;
  private Timestamp updateTime;
  private Byte status;

}
