package IOModules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultSystemResponse {
    long time;
    double x1;
    double x2;
    double steps;
}
