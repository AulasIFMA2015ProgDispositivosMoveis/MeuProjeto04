package com.aula.meuprojeto04;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class Principal extends ActionBarActivity {

	private Spinner cmbSabores;
	private RadioGroup rgbFormasdePagamento;
	private CheckBox chkRefri, chkBordas;
	private Button btnEnviar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //criação do Array que irá conter os sabores
        String sabores[] = {"Jaca","Buriti","Calabresa","Farinha D'agua"};
        //Criação do ArrayAdapter que será adicionado ao Spinner
        ArrayAdapter<String> meuadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sabores);
        //Recupera os componentes do XML
        cmbSabores = (Spinner) findViewById(R.id.cmbSabores);
        rgbFormasdePagamento = (RadioGroup) findViewById(R.id.rbgFormapag);
        chkRefri = (CheckBox) findViewById(R.id.chkRefri);
        chkBordas = (CheckBox) findViewById(R.id.chkBorda);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Adiciona o ArrayAdapter ao Spinner
        cmbSabores.setAdapter(meuadapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void mostrarEscolha(View v){
    	//Método chamado no click do Botão (ver XML de layout)
    	
    	String pizza,adicionais="",formapag="",msg;
    	
    	//Recupera o que foi selecionado pelo usuário na combo de sabores
    	pizza = cmbSabores.getSelectedItem().toString();
    	
    	//Verifica qual CheckBox foi selecionado
    	if (chkBordas.isChecked()) {
			adicionais = adicionais + " Bordas ";
		}
    	
    	if (chkRefri.isChecked()) {
    		adicionais = adicionais + " Refrigerante ";
		}
    	
    	//Verifica qual Radio foi selecionado
    	switch (rgbFormasdePagamento.getCheckedRadioButtonId()) {
			case R.id.rdDinheiro:
				formapag = "Em Dinheiro";
				break;
			case R.id.rdCartao:
				formapag = "Em Cartão";
				break;
		}
    	
    	msg = "Sabor Escolhido:" + pizza + "\n";
    	msg = msg + "Adicionais:" + adicionais + "\n";
    	msg = msg + "Forma de Pagamento:" + formapag;
    	
    	AlertDialog.Builder alerta = new AlertDialog.Builder(this);
    	alerta.setTitle("Pizza de SI");
    	alerta.setMessage(msg);
    	alerta.setPositiveButton("Ok", null);
    	alerta.show();
    	//Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
}
