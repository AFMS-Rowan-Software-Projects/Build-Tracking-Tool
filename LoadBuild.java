import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;

/*
 * Creates the window used to either create or load build.
 * The window states if it's ECM or TD side and will only open windows
 * for each side accordingly.
 * 
 */

public class LoadBuild {
	private static Text text;
	private static Text text_2;
	private static Text text_3;

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(1024, 600);
		shell.setText("Load Build");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(35, 72, 350, 40);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(634, 106, 350, 40);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(634, 189, 350, 40);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(387, 431, 199, 63);
		btnNewButton.setText("Submit");
		
		
		
		Label lblLoadBuild = new Label(shell, SWT.NONE);
		lblLoadBuild.setBounds(92, 41, 228, 25);
		lblLoadBuild.setText("Load build to add information to");
		
		Label lblDatetime = new Label(shell, SWT.NONE);
		lblDatetime.setText("Date for completion");
		lblDatetime.setBounds(130, 158, 190, 25);
		
		Label lblContribution = new Label(shell, SWT.NONE);
		lblContribution.setText("Contribution");
		lblContribution.setBounds(634, 75, 114, 25);
		
		Label lblNotes = new Label(shell, SWT.NONE);
		lblNotes.setText("Notes");
		lblNotes.setBounds(634, 158, 81, 25);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.CALENDAR);
		dateTime.setBounds(35, 189, 350, 211);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println(dateTime.getMonth());
				System.out.println(dateTime.getDay());
				System.out.println(dateTime.getYear());
				shell.close();
				CreateLoad.main(null, true);
				
			}
		});
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}