package com.example.Rename;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RenameFiles {

	private static File[] fileContainer;
	private static String returnString = "Datei";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JFileChooser-Objekt erstellen
		JFileChooser chooser = new JFileChooser();

		// Only files are selectable
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		chooser.setMultiSelectionEnabled(true);

		// Dialog zum Oeffnen von Dateien anzeigen
		int returnValue = chooser.showDialog(null, "Dateiauswahl");

		// Approve button clicked
		if (returnValue == JFileChooser.APPROVE_OPTION) {

			fileContainer = chooser.getSelectedFiles();

			returnString = JOptionPane
					.showInputDialog("Neuen Dateinamen eingeben.");

			System.out.println(returnString);

			int counter = 0;
			for (File file : fileContainer) {
				String[] splittedName = file.getName().split("\\.");

				String suffix = splittedName[splittedName.length - 1];

				File newFileName = new File(file.getParentFile()
						+ File.separator + returnString + "_" + counter + "."
						+ suffix); // file.renameTo(new
									// File(file.getParentFile()));
				counter++;

				try {
					if (file.renameTo(newFileName)) {
						System.out.println("File renamed successfull !");
					} else {
						System.out.println("File rename operation failed !");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				// System.out.println(file.getParentFile());
				// System.out.println(file);

			}
		}

	}

}
