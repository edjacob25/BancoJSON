import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ClienteIUG extends Frame implements ActionListener
{
	private JTextField tfNocta 	 = new JTextField();
	private JTextField tfNombre  = new JTextField();
	String[] cuentas = {"INVERSION", "AHORRO","CREDITO","HIPOTECA"};
	private JComboBox tfTipo    = new JComboBox(cuentas);
	private JTextField tfSaldo   = new JTextField();
	private JTextField tfTipoCuenta = new JTextField();
	private JButton    bCapturar, bConsultar, bTipo, bNocta, bModificar, bActualizar, bRetiro, bDeposito, bLimpiar, bCancelar ,bSalir;
	private JTextArea  taDatos   = new JTextArea(13,30);
	
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	
	private ClienteAD banco = new ClienteAD();
	

	public ClienteIUG()
	{
		super("BANAMEX Catalogo Local de Clientes");
		p1.setLayout(new GridLayout(12,2));
		
		p1.add(new Label("No. de Cuenta: "));
		p1.add(tfNocta);
		
		p1.add(new Label("Nombre: "));
		p1.add(tfNombre);
		
		p1.add(new Label("Tipo de Cuenta: "));
		p1.add(tfTipo);
		
		p1.add(new Label("Saldo"));
		p1.add(tfSaldo);

		p1.add(new Label("Tipo De Cuenta actual"));
		tfTipoCuenta.setEnabled(false);
		p1.add(tfTipoCuenta);
				
		bCapturar = new JButton("Capturar Cliente");
		bCapturar.addActionListener(this);
		p1.add(bCapturar);
		
		bConsultar = new JButton("Consultar Clientes");
		bConsultar.addActionListener(this);
		p1.add(bConsultar);
		
		bNocta = new JButton("Consultar No. de cuenta");
		bNocta.addActionListener(this);
		p1.add(bNocta);


		bTipo = new JButton("Consultar tipo de cuenta");
		bTipo.addActionListener(this);
		p1.add(bTipo);

		bActualizar = new JButton("Actualizar informacion");
		bActualizar.addActionListener(this);
		bActualizar.setEnabled(false);
		p1.add(bActualizar);

		bModificar = new JButton("Modificar registro");
		bModificar.addActionListener(this);
		p1.add(bModificar);

		bCancelar = new JButton("Cancelar transaccion");
		bCancelar.addActionListener(this);
		bCancelar.setEnabled(false);
		p1.add(bCancelar);


		bDeposito = new JButton("Deposito");
		bDeposito.addActionListener(this);
		p1.add(bDeposito);

		bLimpiar = new JButton("Limpiar Campos");
		bLimpiar.addActionListener(this);
		p1.add(bLimpiar);

		bRetiro = new JButton("Retiro");
		bRetiro.addActionListener(this);
		p1.add(bRetiro);
						
		bSalir = new JButton("SALIR");
		bSalir.addActionListener(this);
		p1.add(bSalir);
				
		p2.setLayout(new FlowLayout());
		
		p2.add(p1);
		p2.add(new JScrollPane(taDatos));
		
		add(p2);
		setSize(500,500);
		setVisible(true);
	}
	
	private void deshabilitarBotones()
	{
		if (bTipo.isEnabled()) {
			bCapturar.setEnabled(false);
			bConsultar.setEnabled(false);
			bTipo.setEnabled(false);
			bNocta.setEnabled(false);
			bSalir.setEnabled(false);
			bModificar.setEnabled(false);
			bDeposito.setEnabled(false);
			bRetiro.setEnabled(false);
			bActualizar.setEnabled(true);
			bCancelar.setEnabled(true);
		}
		else
		{
			bCapturar.setEnabled(true);
			bConsultar.setEnabled(true);
			bTipo.setEnabled(true);
			bNocta.setEnabled(true);
			bSalir.setEnabled(true);
			bModificar.setEnabled(true);
			bDeposito.setEnabled(true);
			bRetiro.setEnabled(true);
			bActualizar.setEnabled(false);
			bCancelar.setEnabled(false);
		}
	}


	private String obtenerDatos()
	{
		String datos="";

        String cuenta = tfNocta.getText();
        String nombre = tfNombre.getText();
        String tipo   = (String) tfTipo.getSelectedItem();
        String saldo  = tfSaldo.getText();

        if(cuenta.equals("") || nombre.equals("") || tipo.equals("") || saldo.isEmpty())
            datos = "VACIO";
        else
        {
            try
            {
                int s = Integer.parseInt(saldo);
                datos = cuenta+"_"+nombre+"_"+tipo+"_"+saldo;
            }
            catch(NumberFormatException nfe)
            {
                datos = "NO_NUMERICO";
            }
        }

        return datos;
	}
	
	private void desplegarDatos(String datos)
	{
		StringTokenizer st = new StringTokenizer(datos,"_");
		
		tfNocta.setText(st.nextToken());
		tfNombre.setText(st.nextToken());
		tfTipoCuenta.setText(st.nextToken());
		tfSaldo.setText(st.nextToken());
	}

	private void deshabilitarTf(JTextField tf)
	{
		if (tf.isEnabled()) {
			//tf.setText("");
			tf.setEnabled(false);
		}
		else
		{
			tf.setText("");
			tf.setEnabled(true);
		}
	}
		
	public void actionPerformed(ActionEvent e)
	{
		String respuesta = "";
		
		if (e.getSource() == bCapturar)
		{
			// 1. Obtener datos de los textfields
            String datos = obtenerDatos();

            if(datos.equals("VACIO"))
                taDatos.setText("Algun campo esta vacio...");
            else
            {
                if(datos.equals("NO_NUMERICO"))
                    taDatos.setText("Saldo debe ser numerico...");
                else
                {
                    // 2. Enviar los datos al objeto AD a treaves del metodo capturar
                    respuesta = banco.capturar(datos);

                    // 3. Desplegar el resultado de la transaccion
                    taDatos.setText(respuesta);
                }
            }
		}
		
		if (e.getSource() == bLimpiar) {
			desplegarDatos("_ _ _ _ _ ");
		}

		if (e.getSource() == bDeposito) {
			String cuenta = JOptionPane.showInputDialog("No Cuenta");
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
			String respueta = banco.depositar(cuenta, cantidad);
			taDatos.setText(respueta);
		}

		if (e.getSource() == bRetiro) {
			String cuenta = JOptionPane.showInputDialog("No Cuenta");
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
			String respueta = banco.retirar(cuenta, cantidad);
			taDatos.setText(respueta);
		}

		if (e.getSource() == bConsultar)
		{			
			String datos = banco.consultarDatos();
			taDatos.setText(datos);
		}

		if (e.getSource() == bNocta) 
		{
			String datos = banco.consultarNocta(tfNocta.getText());
			desplegarDatos(datos);
			taDatos.setText(datos);
		}
		
		if (e.getSource() == bTipo) 
		{
			String datos = banco.consultarTipo((String)tfTipo.getSelectedItem());
			desplegarDatos(datos);
			taDatos.setText(datos);
		}	

		if (e.getSource() == bModificar) {

			
			if (tfNocta.getText()!="") {
				String datos = banco.consultarNocta(tfNocta.getText());
				desplegarDatos(datos);
				taDatos.setText(datos);
				deshabilitarBotones();
				deshabilitarTf(tfNocta);
			}
			else{
				taDatos.setText("Clave vacia");
			}
		}

		if (e.getSource() == bCancelar)
		{
			deshabilitarBotones();
			deshabilitarTf(tfNocta);
		}

		if (e.getSource() == bActualizar)
		{
			String datos = obtenerDatos();

            if(datos.equals("VACIO"))
                taDatos.setText("Algun campo esta vacio...");
            else
            {
                if(datos.equals("NO_NUMERICO"))
                    taDatos.setText("Saldo debe ser numerico...");
                else
                {
                    // 2. Enviar los datos al objeto AD a treaves del metodo capturar
                    respuesta = banco.modificar(datos);

                    // 3. Desplegar el resultado de la transaccion
                    taDatos.setText(respuesta);
                    deshabilitarTf(tfNocta);
                    deshabilitarBotones();
                }
            }

		}
		
		if (e.getSource() == bSalir)
			System.exit(0);
		
	}
	
	public static void main(String args[])
	{
		new ClienteIUG();
	}
}