import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

/* Window for CreateLoad, has a boolean for if the ECM button is selected
 * If ECM is selected then it allows connections to ECM side windows,
 * otherwise it allows connections to the TD side
 * 
 */
public class CreateLoad{

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args, boolean eCMbutton) {
		
		//Creates the actual Window with Size 1024x600
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(1024, 600);
		shell.setText("Create or Load");
		
		//Creates the button for Creating a new build
		Button btnCreate = new Button(shell, SWT.NONE);
		btnCreate.setBounds(383, 180, 213, 110);
		btnCreate.setText("Create New Build");
		
		//Creates the button for Loading a previous Build
		Button btnLoad = new Button(shell, SWT.NONE);
		btnLoad.setBounds(383, 322, 213, 110);
		btnLoad.setText("Load Created Build");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				LoadBuild.main(args);
			}
		});
		
		//Creates the label at the top and sets it's text to a Welcome message
		Label lblWelcomeWouldYou = new Label(shell, SWT.NONE);
		lblWelcomeWouldYou.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblWelcomeWouldYou.setBounds(135, 10, 754, 76);
		lblWelcomeWouldYou.setText("Welcome, would you like to create a new build or load an already created one?");
		
		//Creates the label for which side you are currently on, and sets it according to the
		// selection of the radio buttons on the login
		//This check also is used to select which window should be opened after selecting create or load
		Label lblEmcSide = new Label(shell, SWT.NONE);
		lblEmcSide.setBounds(460, 92, 70, 20);
		if(eCMbutton)
		{
			//Sets label as ECM Side, also includes action listener for the correct side (ECM Side)
			lblEmcSide.setText("ECM Side");
			btnCreate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					shell.close();
					new Builds();
				}
			});
		}
		else
		{
			//Sets label as TD Side, also includes action listener for the correct side (TD Side)
			lblEmcSide.setText("TD Side");
			btnCreate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					shell.close();
					new New_Build();
				}
			});
		}

		//Opens the window and makes it visible, also sets the program to sleep while waiting for input
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
