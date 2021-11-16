package yaho.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ChartForm {
    private List<String> labels;
    private List<Integer> dataset;
}
