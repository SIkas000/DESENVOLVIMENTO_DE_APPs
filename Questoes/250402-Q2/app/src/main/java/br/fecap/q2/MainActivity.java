package br.fecap.q2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText textNumber;
    RadioGroup radioGroup;
    RadioButton rbOpcao1, rbOpcao2, rbOpcao3;
    Button btnSet;
    TextView textResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumber = findViewById(R.id.textNumber);

        radioGroup = findViewById(R.id.radioGroup);
        rbOpcao1 = findViewById(R.id.rbOpcao1);
        rbOpcao2 = findViewById(R.id.rbOpcao2);
        rbOpcao3 = findViewById(R.id.rbOpcao3);

        btnSet = findViewById(R.id.btnSet);
        textResposta = findViewById(R.id.textResultado);

        btnSet.setOnClickListener(v -> {
            String salarioStr = textNumber.getText().toString();

            if (!salarioStr.isEmpty()) {
                double salario = Double.parseDouble(salarioStr);
                double novoSalario = 0;

                int checkedId = radioGroup.getCheckedRadioButtonId();
                if (checkedId == R.id.rbOpcao1) {
                    novoSalario = salario * 1.40;
                } else if (checkedId == R.id.rbOpcao2) {
                    novoSalario = salario * 1.45;
                } else if (checkedId == R.id.rbOpcao3) {
                    novoSalario = salario * 1.50;
                }

                String resultado = String.format("Novo salário: R$ %.2f", novoSalario);
                textResposta.setText(resultado);
            } else {
                textResposta.setText("Digite um salário válido.");
            }
        });
    }
}