/* The program it was developed by "imichat development project".
 * If you want to modify or alter this program, please contact the development team.
 * If you do if you have discovered a bug in this program, please contact as soon as possible the development team.
 */

package imichatgit;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class EchoClient2 extends Thread implements ActionListener {
	public static final int ECHO_PORT = 30000;

    public void DateLoad(){
    	Date date = new Date();
    	console.append(date.toString());
    }

    static JFrame mainframe = new JFrame();
    JPanel panel_sender = new JPanel();
    JPanel panel_console = new JPanel();
    JTextField name = new JTextField("名前を入力してください", 30);
    JTextField naiyou = new JTextField("本文", 30);
    JButton sendbutton = new JButton();
    JTextArea console = new JTextArea();
    JScrollPane scroll_console = new JScrollPane(console);
    FlowLayout layout = new FlowLayout();
	String namaebox;
	Socket socket = null; //socketを制作
    PrintStream os = null;
    BufferedReader is = null;

	public static void main (String[] args) {
        String host = "localhost";
        String value = JOptionPane.showInputDialog(mainframe, "サーバーアドレスを入力してください。");
		if (value == null){
			JOptionPane.showInternalMessageDialog(mainframe, "未入力です。");
		} else {
			if (value.length() > 0) {
				host = value;
			}
		}

		EchoClient2 client = new EchoClient2();
		client.createClient(host);
        client.start();
	}

	public EchoClient2() {
	}

    public void run() {
        try {
            // サーバーからのメッセージを受け取り画面に表示します
            String responseLine;
            String responseLine2;
            while (true) {
                responseLine = is.readLine();
                if ("[close]".equals(responseLine) || responseLine == null) {
                    break;
                }
                DateLoad();
    			console.append("Server:" + responseLine + "\n");
                System.out.println("Server: " + responseLine);

            }
        } catch (UnknownHostException e) {
            System.err.println("Trying to connect to unknown host: " + e);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

	private void createClient(String host) {
		Date dat = new Date(); //日付を取得]"; //ログを設定
		try {

			socket = new Socket(host, ECHO_PORT); //socketを制作
	        os = new PrintStream(socket.getOutputStream());
	        is = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
	        /*
			Scanner s = new Scanner(System.in); 文章用のスキャナー
			sendb.addActionListener(this);
			sendb.setText("送信（send）");
			textframe.setSize(840, 480);
			textframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			texter.setSize(830, 450);
			texter.setEditable(false);
			namaeran.setSize(10, 30);
			JScrollPane texters = new JScrollPane(texter);
			texters.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			texters.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 	texters.setSize(830, 450);
		 	texters.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		 	texters.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 	texters.setBorder(new BevelBorder(BevelBorder.RAISED));
			tf.setSize(830, 450);
			tf.add(textfield);
			tf.add(sendb);
			FlowLayout layout = new FlowLayout();
			JPanel textarea1 = new JPanel();
			textarea1.add(texters, BorderLayout.CENTER);
			textarea1.setLayout(new FlowLayout(FlowLayout.CENTER));
			JPanel nyuryoku = new JPanel();
			Container contentpane1 = textframe.getContentPane();
			Container contentpane2 = textframe.getContentPane();
			Container buttonpane = textframe.getContentPane();
			Container namaepane = textframe.getContentPane();
			Container textareapane = textframe.getContentPane();
			layout.setAlignment(FlowLayout.CENTER);
			namaepane.setLayout(layout);
			//textarea1.add(texter);
			//textarea1.add(texters);
			nyuryoku.add(namaeran);
			nyuryoku.add(textfield);
			//nyuryoku.add(sendb);
			//nyuryoku.add(texters);
			nyuryoku.setLayout(layout);
			namaepane.add(nyuryoku, BorderLayout.NORTH);
			//contentpane1.add(textarea1, BorderLayout.CENTER);
			//contentpane1.setSize(830, 450);
			*/


	        mainframe.setSize(840, 480);

	        sendbutton.addActionListener(this);
	        sendbutton.setText("Send");

	        console.setEditable(false);
	        //console.setSize(830, 450);
	        

	        name.setSize(10, 30);

	        scroll_console.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        scroll_console.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	        scroll_console.setSize(830, 450);
	        scroll_console.setBounds(10, 10, 150, 300);

	        panel_sender.add(name);
	        panel_sender.add(naiyou);
	        panel_sender.add(sendbutton);

	        panel_console.setLayout(layout);

	        //panel_console.add(console);
	        panel_console.add(scroll_console);

	        Container mainpane = mainframe.getContentPane();

	        mainpane.add(panel_sender, BorderLayout.SOUTH);
	        mainpane.add(panel_console, BorderLayout.NORTH);




			console.append("サーバーに接続しています・・・。" + "行先" + socket.getRemoteSocketAddress() + "\n");

			//namael.setText("まず、名前を設定して、コメントを入力してください。");

			mainframe.setVisible(true);

			System.out.println(dat +"接続しました。"
				+ socket.getRemoteSocketAddress());
			console.append("サーバーに接続しました。" + "行先" + socket.getRemoteSocketAddress() + "\n");
			//namael.setText("まず、名前を設定して、コメントを入力してください。" + "\n");
			console.append(dat + "接続しました。" + socket.getRemoteSocketAddress() + "\n");
			//BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
			//String success = log + dat + "接続しました。" + socket.getLocalPort();
			namaebox = name.getText();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			String message = naiyou.getText(); //入力した文章をscannに設定
			if (message == null || message.length() <= 0) {
				try {
					if (socket != null) {
						socket.close();
					}
				} catch (IOException err) {
					System.out.println("切断されました。"
						+ socket.getRemoteSocketAddress());
				}
				return;
			}
			System.out.println(message);

			// メッセージを送ります
			//label1.setText("送信しています・・・。");
			namaebox = name.getText();
			message = " " + namaebox + "さん" + "    " + message + "\n";
			os.write(message.getBytes(Charset.forName("UTF-8")));
			os.flush();

			console.append("Client:"+ name.getText() + "さん：" +  message);

			System.out.println("【文字列を読み込みます。】");
			//label1.setText("コメントを入力してください。");

			System.out.println("コメントを入力してください。");
		} catch (IOException err) {
			err.printStackTrace();
			System.out.println("鯖が死にました。管理人の気が向いたら直します。");
		}

	}

}
