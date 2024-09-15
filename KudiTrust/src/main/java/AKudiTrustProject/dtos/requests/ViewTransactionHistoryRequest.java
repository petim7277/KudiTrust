package AKudiTrustProject.dtos.requests;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ViewTransactionHistoryRequest {
  private Date date;
  private BigDecimal amount;
}
