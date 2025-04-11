package br.com.fecapccp.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefrigerante;
    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        cbArroz = findViewById(R.id.cbaArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbRefrigerante = findViewById(R.id.cbRefrigerante);
        btnSet = findViewById(R.id.btnSet);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar(View view) {
        checkBox();
    }

    public void checkBox() {
        String texto;
        double total = 0.0;

        if (cbArroz.isChecked()) {
            String produtoSelecionado = cbArroz.getText().toString();
            int inicio = produtoSelecionado.indexOf("R$") + 3;
            int fim = produtoSelecionado.indexOf(")");
            String valorStr = produtoSelecionado.substring(inicio, fim).replace(",", ".");
            double valor = Double.parseDouble(valorStr);
            total += valor;
        }

        if (cbLeite.isChecked()) {
            String produtoSelecionado = cbLeite.getText().toString();
            int inicio = produtoSelecionado.indexOf("R$") + 3;
            int fim = produtoSelecionado.indexOf(")");
            String valorStr = produtoSelecionado.substring(inicio, fim).replace(",", ".");
            double valor = Double.parseDouble(valorStr);
            total += valor;

        }

        if (cbCarne.isChecked()) {
            String produtoSelecionado = cbCarne.getText().toString();
            int inicio = produtoSelecionado.indexOf("R$") + 3;
            int fim = produtoSelecionado.indexOf(")");
            String valorStr = produtoSelecionado.substring(inicio, fim).replace(",", ".");
            double valor = Double.parseDouble(valorStr);
            total += valor;

        }

        if (cbFeijao.isChecked()) {
            String produtoSelecionado = cbFeijao.getText().toString();
            int inicio = produtoSelecionado.indexOf("R$") + 3;
            int fim = produtoSelecionado.indexOf(")");
            String valorStr = produtoSelecionado.substring(inicio, fim).replace(",", ".");
            double valor = Double.parseDouble(valorStr);
            total += valor;

        }

        if (cbRefrigerante.isChecked()) {
            String produtoSelecionado = cbRefrigerante.getText().toString();
            int inicio = produtoSelecionado.indexOf("R$") + 3;
            int fim = produtoSelecionado.indexOf(")");
            String valorStr = produtoSelecionado.substring(inicio, fim).replace(",", ".");
            double valor = Double.parseDouble(valorStr);
            total += valor;
        }


         texto = "Total: R$ " + String.format("%.2f", total).replace(".", ",");

        textResultado.setText(texto);
    }
}
