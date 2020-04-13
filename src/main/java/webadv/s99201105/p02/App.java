package webadv.s99201105.p02;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;




public class App {
    public static void main(String[] args) throws IOException {
    	//创造一个文件并写入
    	FileWriter fw = new FileWriter("user.txt");
    	BufferedWriter bw = new BufferedWriter(fw);
    	bw.write("17201232\n");//账号
    	bw.write(sha256hex("123456"));//密码
    	bw.close();
    	fw.close();
    	String account = "";
    	String pwd = "";
    	Scanner input = new Scanner(System.in);
    	System.out.println("请输入你的账号:");
    	account = input.nextLine();
    	System.out.println("请输入你的密码:");
    	pwd = input.nextLine();
    	
    	FileReader fr = new FileReader("user.txt");
    	BufferedReader bf = new BufferedReader(fr);
    	String tAccount = bf.readLine();
    	String tPwd = bf.readLine();
    	bf.close();
    	fr.close();
    	
    	if(account.equals(tAccount)&&sha256hex(pwd).equals(tPwd)) {
    		System.out.println("登录成功");
    	}else {
    		System.out.println("登录失败");
    	}
    }

    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }

}
