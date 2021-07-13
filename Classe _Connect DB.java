-Class ConectDb
using System;
using System.Security.Cryptography;
using System.Windows.Forms;

namespace CifraCLN
{
    public partial class FormPrincipal : Form
    {
        public FormPrincipal()
        {
            InitializeComponent();
        }

        private void limpar_Click(object sender, EventArgs e)
        {
            textBox1.Text = String.Empty;
            textBox2.Text = String.Empty;
            textBox3.Text = String.Empty;
        }

        private void descrip_Click(object sender, EventArgs e)
        {
            textBox3.Text = String.Empty;
            for (int i = 0; i < textBox2.Text.Length; i++)
            {
                int txtCrip = (int)textBox2.Text[i];
                int txtUsuario = txtCrip - (2 * (i));
                textBox3.Text += Char.ConvertFromUtf32(txtUsuario);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            form2.ShowDialog();
        }

        private void Auto_Click_1(object sender, EventArgs e)
        {
            if (comboBox1.Text == "SHA512")
            {
                textBox3.Visible = false;
                descrip.Visible = false;
                textBox2.Text = "";
                var hash = new TrataHash(SHA512.Create());
                textBox2.Text = hash.GerarHash(textBox1.Text);
            }
            if (comboBox1.Text == "MD5")
            {
                textBox3.Visible = false;
                descrip.Visible = false;
                textBox2.Text = "";
                var hash = new TrataHash(MD5.Create());
                textBox2.Text = hash.GerarHash(textBox1.Text);
            }
            if (comboBox1.Text == "RIPEMD160")
            {
                textBox3.Visible = false;
                descrip.Visible = false;
                textBox2.Text = "";
                var hash = new TrataHash(RIPEMD160.Create());
                textBox2.Text = hash.GerarHash(textBox1.Text);
            }
            if (comboBox1.Text == "Cifra CLN")
            {
                textBox3.Visible = true;
                descrip.Visible = true;
                textBox2.Text = String.Empty;

                for (int i = 0; i < textBox1.Text.Length; i++)
                {
                    int txtUsuario = (int)textBox1.Text[i];
                    int txtCrip = txtUsuario + (2 * (i));
                    textBox2.Text += Char.ConvertFromUtf32(txtCrip);
                }
                textBox1.Text = String.Empty;
            }
            if (comboBox1.
Text == "Selecione o Método" || comboBox1.Text == "" )
            {
                MessageBox.Show("Escolha um método de Criptografia!");
            }
        }

        private void checkBox1_Click(object sender, EventArgs e)
        {

        }
    }
}
