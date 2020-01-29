package com.skul.skul.utils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.stereotype.Component;
public class HeaderFooterPageEvent extends PdfPageEventHelper{
	private PdfTemplate t;
    private Image total;

    public void onOpenDocument(PdfWriter writer, Document document) {
        t = writer.getDirectContent().createTemplate(30, 16);
        try {
            total = Image.getInstance(t);
            total.setRole(PdfName.ARTIFACT);
        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        addHeader(writer);
        addFooter(writer);
    }

    private void addHeader(PdfWriter writer){
        PdfPTable header = new PdfPTable(2);
        try {
            // set defaults
            header.setWidths(new int[]{2, 24});
            header.setTotalWidth(820);
            header.setLockedWidth(true);
            header.getDefaultCell().setFixedHeight(50);
            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
            header.setPaddingTop(40); //50
            // add image
            Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/images.jpg"));
            logo.scaleAbsolute(100, 50);    
            header.addCell(logo);
            // add text
            PdfPCell text = new PdfPCell();
            text.setPaddingBottom(15);
            text.setPaddingLeft(10);
            text.setBorder(Rectangle.BOTTOM);
            text.setBorderColor(BaseColor.LIGHT_GRAY);
            text.addElement(new Phrase("GEOFF BROWN GIRLS HIGH", new Font(Font.FontFamily.HELVETICA, 20)));
            text.addElement(new Phrase("https://geoffbrown.com, Tel : +254708-761-565", new Font(Font.FontFamily.HELVETICA,12)));
            header.addCell(text);
            // write content
            header.writeSelectedRows(0, -1, 15, 590, writer.getDirectContent());
            //header.writeSelectedRows(0, -1, 15, 590, writer.getDirectContent());
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        } catch (MalformedURLException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }
    Font FONT = new Font(Font.FontFamily.HELVETICA,52,Font.BOLD,new GrayColor(0.85f));
    public void onEndPage(PdfWriter writer) {
    	
    	ColumnText.showTextAligned(writer.getDirectContentUnder(),Element.ALIGN_CENTER,new Phrase("GEOFF BROWN GIRLS HIGH",FONT),
    			297.5f,421,writer.getPageNumber() % 2 == 1 ? 45 : -45);
    	
    }

    private void addFooter(PdfWriter writer){
        PdfPTable footer = new PdfPTable(3);
        try {
            // set defaults
            footer.setWidths(new int[]{24, 2, 1});
            footer.setTotalWidth(820);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(35);
            footer.getDefaultCell().setBorder(Rectangle.TOP);
            Object BaseColor;
			//footer.getDefaultCell().setBorderColorLeft(Color.BLUE);

            // add copyright
            footer.addCell(new Phrase("\u00A9 javenock.com", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

            // add current page count
            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

            // add placeholder for total page count
            PdfPCell totalPageCount = new PdfPCell(total);
            totalPageCount.setBorder(Rectangle.TOP);
        // totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
            footer.addCell(totalPageCount);

            // write page
            PdfContentByte canvas = writer.getDirectContent();
            canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
            footer.writeSelectedRows(0, -1, 15, 42, canvas);
            canvas.endMarkedContentSequence();
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    public void onCloseDocument(PdfWriter writer, Document document) {
        int totalLength = String.valueOf(writer.getPageNumber()).length();
        int totalWidth = totalLength * 5;
        ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
                new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
                totalWidth, 6, 0);
    }
}
