package org.rama.todogoogleapi.service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.SheetProperties;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import org.rama.todogoogleapi.config.GoogleApiConfig;
import org.rama.todogoogleapi.dto.GoogleApiDto;
import org.rama.todogoogleapi.dto.SpreadsheetLite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleApiService {

    @Autowired
    private GoogleApiConfig googleApiConfig;

    public SpreadsheetLite createSheet(GoogleApiDto request) throws IOException, GeneralSecurityException {

            Sheets service = googleApiConfig.getService();

            // Creating Sheet Properties
            SheetProperties sheetProperties = new SheetProperties();
            sheetProperties.setTitle(request.getSheetName());
            Sheet sheet = new Sheet().setProperties(sheetProperties);

            // Creating SpreadSheet Properties
            SpreadsheetProperties spreadsheetProperties = new SpreadsheetProperties();
            spreadsheetProperties.setTitle(request.getSheetName());
            Spreadsheet spreadsheet = new Spreadsheet().setProperties(spreadsheetProperties).setSheets(Collections.singletonList(sheet));

            // Creating a spread Sheet
            Spreadsheet createResponse = service.spreadsheets().create(spreadsheet).execute();

            return new SpreadsheetLite(createResponse);

    }
}
