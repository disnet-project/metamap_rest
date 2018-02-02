/*
***************************************************************************
*
*                          PUBLIC DOMAIN NOTICE
*         Lister Hill National Center for Biomedical Communications
*                      National Library of Medicine
*                      National Institues of Health
*           United States Department of Health and Human Services
*
*  This software is a United States Government Work under the terms of the
*  United States Copyright Act. It was written as part of the authors'
*  official duties as United States Government employees and contractors
*  and thus cannot be copyrighted. This software is freely available
*  to the public for use. The National Library of Medicine and the
*  United States Government have not placed any restriction on its
*  use or reproduction.
*
*  Although all reasonable efforts have been taken to ensure the accuracy
*  and reliability of the software and data, the National Library of Medicine
*  and the United States Government do not and cannot warrant the performance
*  or results that may be obtained by using this software or data.
*  The National Library of Medicine and the U.S. Government disclaim all
*  warranties, expressed or implied, including warranties of performance,
*  merchantability or fitness for any particular purpose.
*
*  For full details, please see the MetaMap Terms & Conditions, available at
*  http://metamap.nlm.nih.gov/MMTnCs.shtml.
*
**************************************************************************
*/

/* replace_UTF8 is a very simple program used to convert non-ASCII characters
   to ASCII where we have a mapping.  If there is no mapping in the HashMap
   below, the non-ASCII character will be converted to a question mark '?'.
   Most mappings are one to one, others like Greek alphabet characters
   are spelled out.

   Usage:

     cat file | java replace_UTF8 > result

    or

     java replace_UTF8 file > result
*/
package edu.upm.midas.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by METAMAP on last modified 13/05/2015.
 *
 * @author Gerardo Lagunes G. ${EMAIL} Change the implementation (delete main method)
 * @version ${<VERSION>}
 * @project edsss
 * @className ReplaceUTF8
 * @see
 */
@Service
public class ReplaceUTF8 {

    @Autowired
    private Common common;

        private static HashMap<Character, String> char_map =
                new HashMap <> ();
        static
        {
            char_map.put(new Character('\u0020'), new String(" "));
            char_map.put(new Character('\u0021'), new String("!"));
            char_map.put(new Character('\u0023'), new String("#"));
            char_map.put(new Character('\u0024'), new String("$"));
            char_map.put(new Character('\u0025'), new String("%"));
            char_map.put(new Character('\u0026'), new String("&"));
            char_map.put(new Character('\u0028'), new String("("));
            char_map.put(new Character('\u0029'), new String(")"));
            char_map.put(new Character('\u002a'), new String("*"));
            char_map.put(new Character('\u002b'), new String("+"));
            char_map.put(new Character('\u002c'), new String(","));
            char_map.put(new Character('\u002d'), new String("-"));
            char_map.put(new Character('\u002e'), new String("."));
            char_map.put(new Character('\u002f'), new String("/"));
            char_map.put(new Character('\u0030'), new String("0"));
            char_map.put(new Character('\u0031'), new String("1"));
            char_map.put(new Character('\u0032'), new String("2"));
            char_map.put(new Character('\u0033'), new String("3"));
            char_map.put(new Character('\u0034'), new String("4"));
            char_map.put(new Character('\u0035'), new String("5"));
            char_map.put(new Character('\u0036'), new String("6"));
            char_map.put(new Character('\u0037'), new String("7"));
            char_map.put(new Character('\u0038'), new String("8"));
            char_map.put(new Character('\u0039'), new String("9"));
            char_map.put(new Character('\u003a'), new String(":"));
            char_map.put(new Character('\u003b'), new String(";"));
            char_map.put(new Character('\u003c'), new String("<"));
            char_map.put(new Character('\u003d'), new String("="));
            char_map.put(new Character('\u003e'), new String(">"));
            char_map.put(new Character('\u003f'), new String("?"));
            char_map.put(new Character('\u0040'), new String("@"));
            char_map.put(new Character('\u0041'), new String("A"));
            char_map.put(new Character('\u0042'), new String("B"));
            char_map.put(new Character('\u0043'), new String("C"));
            char_map.put(new Character('\u0044'), new String("D"));
            char_map.put(new Character('\u0045'), new String("E"));
            char_map.put(new Character('\u0046'), new String("F"));
            char_map.put(new Character('\u0047'), new String("G"));
            char_map.put(new Character('\u0048'), new String("H"));
            char_map.put(new Character('\u0049'), new String("I"));
            char_map.put(new Character('\u004a'), new String("J"));
            char_map.put(new Character('\u004b'), new String("K"));
            char_map.put(new Character('\u004c'), new String("L"));
            char_map.put(new Character('\u004d'), new String("M"));
            char_map.put(new Character('\u004e'), new String("N"));
            char_map.put(new Character('\u004f'), new String("O"));
            char_map.put(new Character('\u0050'), new String("P"));
            char_map.put(new Character('\u0051'), new String("Q"));
            char_map.put(new Character('\u0052'), new String("R"));
            char_map.put(new Character('\u0053'), new String("S"));
            char_map.put(new Character('\u0054'), new String("T"));
            char_map.put(new Character('\u0055'), new String("U"));
            char_map.put(new Character('\u0056'), new String("V"));
            char_map.put(new Character('\u0057'), new String("W"));
            char_map.put(new Character('\u0058'), new String("X"));
            char_map.put(new Character('\u0059'), new String("Y"));
            char_map.put(new Character('\u005a'), new String("Z"));
            char_map.put(new Character('\u005b'), new String("["));
            char_map.put(new Character('\u005d'), new String("]"));
            char_map.put(new Character('\u005e'), new String("^"));
            char_map.put(new Character('\u005f'), new String("_"));
            char_map.put(new Character('\u0060'), new String("`"));
            char_map.put(new Character('\u0061'), new String("a"));
            char_map.put(new Character('\u0062'), new String("b"));
            char_map.put(new Character('\u0063'), new String("c"));
            char_map.put(new Character('\u0064'), new String("d"));
            char_map.put(new Character('\u0065'), new String("e"));
            char_map.put(new Character('\u0066'), new String("f"));
            char_map.put(new Character('\u0067'), new String("g"));
            char_map.put(new Character('\u0068'), new String("h"));
            char_map.put(new Character('\u0069'), new String("i"));
            char_map.put(new Character('\u006a'), new String("j"));
            char_map.put(new Character('\u006b'), new String("k"));
            char_map.put(new Character('\u006c'), new String("l"));
            char_map.put(new Character('\u006d'), new String("m"));
            char_map.put(new Character('\u006e'), new String("n"));
            char_map.put(new Character('\u006f'), new String("o"));
            char_map.put(new Character('\u0070'), new String("p"));
            char_map.put(new Character('\u0071'), new String("q"));
            char_map.put(new Character('\u0072'), new String("r"));
            char_map.put(new Character('\u0073'), new String("s"));
            char_map.put(new Character('\u0074'), new String("t"));
            char_map.put(new Character('\u0075'), new String("u"));
            char_map.put(new Character('\u0076'), new String("v"));
            char_map.put(new Character('\u0077'), new String("w"));
            char_map.put(new Character('\u0078'), new String("x"));
            char_map.put(new Character('\u0079'), new String("y"));
            char_map.put(new Character('\u007a'), new String("z"));
            char_map.put(new Character('\u007b'), new String("{"));
            char_map.put(new Character('\u007c'), new String("|"));
            char_map.put(new Character('\u007d'), new String("}"));
            char_map.put(new Character('\u007e'), new String("~"));
            char_map.put(new Character('\u00a0'), new String(" "));
            char_map.put(new Character('\u00a1'), new String("!"));
            char_map.put(new Character('\u00a2'), new String("c")); // Cent sign
            char_map.put(new Character('\u00a3'), new String("L")); // Pound sign
            char_map.put(new Character('\u00a4'), new String(" ")); // Currency sign
            char_map.put(new Character('\u00a5'), new String("Y")); // Yen sign
            char_map.put(new Character('\u00a6'), new String("|"));
            char_map.put(new Character('\u00a7'), new String("S")); // Section Sign
            char_map.put(new Character('\u00a8'), new String(""));
            char_map.put(new Character('\u00a9'), new String("(c)"));
            char_map.put(new Character('\u00aa'), new String("a"));
            char_map.put(new Character('\u00ac'), new String("!")); // Not sign
            char_map.put(new Character('\u00ad'), new String("-"));
            char_map.put(new Character('\u00ae'), new String("(r)"));
            char_map.put(new Character('\u00af'), new String("-")); // Macron
            char_map.put(new Character('\u00b0'), new String(" degrees ")); // Degree
            char_map.put(new Character('\u00b1'), new String("+/-"));
            char_map.put(new Character('\u00b2'), new String("2"));
            char_map.put(new Character('\u00b3'), new String("3"));
            char_map.put(new Character('\u00b4'), new String("'"));
            char_map.put(new Character('\u00b5'), new String("u"));
            char_map.put(new Character('\u00b6'), new String(" ")); // Paragraph
            char_map.put(new Character('\u00b7'), new String(".")); // Middle dot
            char_map.put(new Character('\u00b8'), new String(" ")); // Cedilla
            char_map.put(new Character('\u00b9'), new String("1"));
            char_map.put(new Character('\u00ba'), new String("o"));
            char_map.put(new Character('\u00bc'), new String("1/4"));
            char_map.put(new Character('\u00bd'), new String("1/2"));
            char_map.put(new Character('\u00be'), new String("3/4"));
            char_map.put(new Character('\u00bf'), new String("?")); // Inverted Question Mark
            char_map.put(new Character('\u00c0'), new String("A"));
            char_map.put(new Character('\u00c1'), new String("A"));
            char_map.put(new Character('\u00c2'), new String("A"));
            char_map.put(new Character('\u00c3'), new String("A"));
            char_map.put(new Character('\u00c4'), new String("A"));
            char_map.put(new Character('\u00c5'), new String("A"));
            char_map.put(new Character('\u00c6'), new String("AE"));
            char_map.put(new Character('\u00c7'), new String("C"));
            char_map.put(new Character('\u00c8'), new String("E"));
            char_map.put(new Character('\u00c9'), new String("E"));
            char_map.put(new Character('\u00ca'), new String("E"));
            char_map.put(new Character('\u00cb'), new String("E"));
            char_map.put(new Character('\u00cc'), new String("I"));
            char_map.put(new Character('\u00cd'), new String("I"));
            char_map.put(new Character('\u00ce'), new String("I"));
            char_map.put(new Character('\u00cf'), new String("I"));
            char_map.put(new Character('\u00d0'), new String("D")); // Cap Eth
            char_map.put(new Character('\u00d1'), new String("N"));
            char_map.put(new Character('\u00d2'), new String("O"));
            char_map.put(new Character('\u00d3'), new String("O"));
            char_map.put(new Character('\u00d4'), new String("O"));
            char_map.put(new Character('\u00d5'), new String("O"));
            char_map.put(new Character('\u00d6'), new String("O"));
            char_map.put(new Character('\u00d7'), new String("*"));
            char_map.put(new Character('\u00d8'), new String("O"));
            char_map.put(new Character('\u00d9'), new String("U"));
            char_map.put(new Character('\u00da'), new String("U"));
            char_map.put(new Character('\u00db'), new String("U"));
            char_map.put(new Character('\u00dc'), new String("U"));
            char_map.put(new Character('\u00dd'), new String("Y"));
            char_map.put(new Character('\u00de'), new String("P")); // Cap Thorn
            char_map.put(new Character('\u00df'), new String("beta"));
            char_map.put(new Character('\u00e0'), new String("a"));
            char_map.put(new Character('\u00e1'), new String("a"));
            char_map.put(new Character('\u00e2'), new String("a"));
            char_map.put(new Character('\u00e3'), new String("a"));
            char_map.put(new Character('\u00e4'), new String("a"));
            char_map.put(new Character('\u00e5'), new String("a"));
            char_map.put(new Character('\u00e6'), new String("ae"));
            char_map.put(new Character('\u00e7'), new String("c"));
            char_map.put(new Character('\u00e8'), new String("e"));
            char_map.put(new Character('\u00e9'), new String("e"));
            char_map.put(new Character('\u00ea'), new String("e"));
            char_map.put(new Character('\u00eb'), new String("e"));
            char_map.put(new Character('\u00ec'), new String("i"));
            char_map.put(new Character('\u00ed'), new String("i"));
            char_map.put(new Character('\u00ee'), new String("i"));
            char_map.put(new Character('\u00ef'), new String("i"));
            char_map.put(new Character('\u00f1'), new String("n"));
            char_map.put(new Character('\u00f2'), new String("o"));
            char_map.put(new Character('\u00f3'), new String("o"));
            char_map.put(new Character('\u00f4'), new String("o"));
            char_map.put(new Character('\u00f5'), new String("o"));
            char_map.put(new Character('\u00f6'), new String("o"));
            char_map.put(new Character('\u00f7'), new String("/"));
            char_map.put(new Character('\u00f8'), new String("o"));
            char_map.put(new Character('\u00f9'), new String("u"));
            char_map.put(new Character('\u00fa'), new String("u"));
            char_map.put(new Character('\u00fb'), new String("u"));
            char_map.put(new Character('\u00fc'), new String("u"));
            char_map.put(new Character('\u00fd'), new String("y"));
            char_map.put(new Character('\u00fe'), new String("p")); // Thorn
            char_map.put(new Character('\u00ff'), new String("y"));
            char_map.put(new Character('\u0100'), new String("A"));
            char_map.put(new Character('\u0101'), new String("a"));
            char_map.put(new Character('\u0102'), new String("A"));
            char_map.put(new Character('\u0103'), new String("a"));
            char_map.put(new Character('\u0104'), new String("A"));
            char_map.put(new Character('\u0105'), new String("a"));
            char_map.put(new Character('\u0106'), new String("C"));
            char_map.put(new Character('\u0107'), new String("c"));
            char_map.put(new Character('\u0108'), new String("C"));
            char_map.put(new Character('\u0109'), new String("c"));
            char_map.put(new Character('\u010a'), new String("C"));
            char_map.put(new Character('\u010b'), new String("c"));
            char_map.put(new Character('\u010c'), new String("C"));
            char_map.put(new Character('\u010d'), new String("c"));
            char_map.put(new Character('\u010e'), new String("D"));
            char_map.put(new Character('\u010f'), new String("d"));
            char_map.put(new Character('\u0110'), new String("D"));
            char_map.put(new Character('\u0111'), new String("d"));
            char_map.put(new Character('\u0112'), new String("E"));
            char_map.put(new Character('\u0113'), new String("e"));
            char_map.put(new Character('\u0114'), new String("E"));
            char_map.put(new Character('\u0115'), new String("e"));
            char_map.put(new Character('\u0116'), new String("E"));
            char_map.put(new Character('\u0117'), new String("e"));
            char_map.put(new Character('\u0118'), new String("E"));
            char_map.put(new Character('\u0119'), new String("e"));
            char_map.put(new Character('\u011a'), new String("E"));
            char_map.put(new Character('\u011b'), new String("e"));
            char_map.put(new Character('\u011c'), new String("G"));
            char_map.put(new Character('\u011d'), new String("g"));
            char_map.put(new Character('\u011e'), new String("G"));
            char_map.put(new Character('\u011f'), new String("g"));
            char_map.put(new Character('\u0120'), new String("G"));
            char_map.put(new Character('\u0121'), new String("g"));
            char_map.put(new Character('\u0122'), new String("G"));
            char_map.put(new Character('\u0123'), new String("g"));
            char_map.put(new Character('\u0124'), new String("H"));
            char_map.put(new Character('\u0125'), new String("h"));
            char_map.put(new Character('\u0126'), new String("H"));
            char_map.put(new Character('\u0127'), new String("h"));
            char_map.put(new Character('\u0128'), new String("I"));
            char_map.put(new Character('\u0129'), new String("i"));
            char_map.put(new Character('\u012a'), new String("I"));
            char_map.put(new Character('\u012b'), new String("i"));
            char_map.put(new Character('\u012c'), new String("I"));
            char_map.put(new Character('\u012d'), new String("i"));
            char_map.put(new Character('\u012e'), new String("I"));
            char_map.put(new Character('\u012f'), new String("i"));
            char_map.put(new Character('\u0130'), new String("I"));
            char_map.put(new Character('\u0131'), new String("i"));
            char_map.put(new Character('\u0132'), new String("IJ"));
            char_map.put(new Character('\u0133'), new String("ij"));
            char_map.put(new Character('\u0134'), new String("J"));
            char_map.put(new Character('\u0135'), new String("j"));
            char_map.put(new Character('\u0136'), new String("K"));
            char_map.put(new Character('\u0137'), new String("k"));
            char_map.put(new Character('\u0139'), new String("L"));
            char_map.put(new Character('\u013a'), new String("l"));
            char_map.put(new Character('\u013b'), new String("L"));
            char_map.put(new Character('\u013c'), new String("l"));
            char_map.put(new Character('\u013d'), new String("L"));
            char_map.put(new Character('\u013e'), new String("l"));
            char_map.put(new Character('\u013f'), new String("L"));
            char_map.put(new Character('\u0140'), new String("l"));
            char_map.put(new Character('\u0141'), new String("L"));
            char_map.put(new Character('\u0142'), new String("l"));
            char_map.put(new Character('\u0143'), new String("N"));
            char_map.put(new Character('\u0144'), new String("n"));
            char_map.put(new Character('\u0145'), new String("N"));
            char_map.put(new Character('\u0146'), new String("n"));
            char_map.put(new Character('\u0147'), new String("N"));
            char_map.put(new Character('\u0148'), new String("n"));
            char_map.put(new Character('\u0149'), new String("n"));
            char_map.put(new Character('\u014c'), new String("O"));
            char_map.put(new Character('\u014d'), new String("o"));
            char_map.put(new Character('\u014e'), new String("O"));
            char_map.put(new Character('\u014f'), new String("o"));
            char_map.put(new Character('\u0150'), new String("O"));
            char_map.put(new Character('\u0151'), new String("o"));
            char_map.put(new Character('\u0152'), new String("OE"));
            char_map.put(new Character('\u0153'), new String("oe"));
            char_map.put(new Character('\u0154'), new String("R"));
            char_map.put(new Character('\u0155'), new String("r"));
            char_map.put(new Character('\u0156'), new String("R"));
            char_map.put(new Character('\u0157'), new String("r"));
            char_map.put(new Character('\u0158'), new String("R"));
            char_map.put(new Character('\u0159'), new String("r"));
            char_map.put(new Character('\u015a'), new String("S"));
            char_map.put(new Character('\u015b'), new String("s"));
            char_map.put(new Character('\u015c'), new String("S"));
            char_map.put(new Character('\u015d'), new String("s"));
            char_map.put(new Character('\u015e'), new String("S"));
            char_map.put(new Character('\u015f'), new String("s"));
            char_map.put(new Character('\u0160'), new String("S"));
            char_map.put(new Character('\u0161'), new String("s"));
            char_map.put(new Character('\u0162'), new String("T"));
            char_map.put(new Character('\u0163'), new String("t"));
            char_map.put(new Character('\u0164'), new String("T"));
            char_map.put(new Character('\u0165'), new String("t"));
            char_map.put(new Character('\u0166'), new String("T"));
            char_map.put(new Character('\u0167'), new String("t"));
            char_map.put(new Character('\u0168'), new String("U"));
            char_map.put(new Character('\u0169'), new String("u"));
            char_map.put(new Character('\u016a'), new String("U"));
            char_map.put(new Character('\u016b'), new String("u"));
            char_map.put(new Character('\u016c'), new String("U"));
            char_map.put(new Character('\u016d'), new String("u"));
            char_map.put(new Character('\u016e'), new String("U"));
            char_map.put(new Character('\u016f'), new String("u"));
            char_map.put(new Character('\u0170'), new String("U"));
            char_map.put(new Character('\u0171'), new String("u"));
            char_map.put(new Character('\u0172'), new String("U"));
            char_map.put(new Character('\u0173'), new String("u"));
            char_map.put(new Character('\u0174'), new String("W"));
            char_map.put(new Character('\u0175'), new String("w"));
            char_map.put(new Character('\u0176'), new String("Y"));
            char_map.put(new Character('\u0177'), new String("y"));
            char_map.put(new Character('\u0178'), new String("Y"));
            char_map.put(new Character('\u0179'), new String("Z"));
            char_map.put(new Character('\u017a'), new String("z"));
            char_map.put(new Character('\u017b'), new String("Z"));
            char_map.put(new Character('\u017c'), new String("z"));
            char_map.put(new Character('\u017d'), new String("Z"));
            char_map.put(new Character('\u017e'), new String("z"));
            char_map.put(new Character('\u017f'), new String("s"));
            char_map.put(new Character('\u0180'), new String("b"));
            char_map.put(new Character('\u0181'), new String("B"));
            char_map.put(new Character('\u0182'), new String("B"));
            char_map.put(new Character('\u0183'), new String("b"));
            char_map.put(new Character('\u0184'), new String("6"));
            char_map.put(new Character('\u0185'), new String("6"));
            char_map.put(new Character('\u0186'), new String("O"));
            char_map.put(new Character('\u0187'), new String("C"));
            char_map.put(new Character('\u0188'), new String("c"));
            char_map.put(new Character('\u0189'), new String("D"));
            char_map.put(new Character('\u018a'), new String("D"));
            char_map.put(new Character('\u018b'), new String("D"));
            char_map.put(new Character('\u018c'), new String("d"));
            char_map.put(new Character('\u018e'), new String("E"));
            char_map.put(new Character('\u0190'), new String("E"));
            char_map.put(new Character('\u0191'), new String("F"));
            char_map.put(new Character('\u0192'), new String("f"));
            char_map.put(new Character('\u0193'), new String("G"));
            char_map.put(new Character('\u0194'), new String("Gamma"));
            char_map.put(new Character('\u0195'), new String("hv"));
            char_map.put(new Character('\u0196'), new String("Iota"));
            char_map.put(new Character('\u0197'), new String("I"));
            char_map.put(new Character('\u0198'), new String("K"));
            char_map.put(new Character('\u0199'), new String("k"));
            char_map.put(new Character('\u019a'), new String("l"));
            char_map.put(new Character('\u019b'), new String("lambda"));
            char_map.put(new Character('\u019c'), new String("M"));
            char_map.put(new Character('\u019d'), new String("N"));
            char_map.put(new Character('\u019e'), new String("n"));
            char_map.put(new Character('\u019f'), new String("O"));
            char_map.put(new Character('\u01a0'), new String("O"));
            char_map.put(new Character('\u01a1'), new String("o"));
            char_map.put(new Character('\u01a2'), new String("OI"));
            char_map.put(new Character('\u01a3'), new String("oi"));
            char_map.put(new Character('\u01a4'), new String("P"));
            char_map.put(new Character('\u01a5'), new String("p"));
            char_map.put(new Character('\u01a6'), new String("YR"));
            char_map.put(new Character('\u01a7'), new String("2"));
            char_map.put(new Character('\u01a8'), new String("2"));
            char_map.put(new Character('\u01ab'), new String("t"));
            char_map.put(new Character('\u01ac'), new String("T"));
            char_map.put(new Character('\u01ad'), new String("t"));
            char_map.put(new Character('\u01ae'), new String("T"));
            char_map.put(new Character('\u01af'), new String("U"));
            char_map.put(new Character('\u01b0'), new String("u"));
            char_map.put(new Character('\u01b1'), new String("Upsilon"));
            char_map.put(new Character('\u01b2'), new String("V"));
            char_map.put(new Character('\u01b3'), new String("Y"));
            char_map.put(new Character('\u01b4'), new String("y"));
            char_map.put(new Character('\u01b5'), new String("Z"));
            char_map.put(new Character('\u01b6'), new String("z"));
            char_map.put(new Character('\u01bb'), new String("2"));
            char_map.put(new Character('\u01bc'), new String("5"));
            char_map.put(new Character('\u01bd'), new String("5"));
            char_map.put(new Character('\u01c0'), new String("|"));
            char_map.put(new Character('\u01c3'), new String("!"));
            char_map.put(new Character('\u01c4'), new String("DZ"));
            char_map.put(new Character('\u01c5'), new String("Dz"));
            char_map.put(new Character('\u01c6'), new String("dz"));
            char_map.put(new Character('\u01c7'), new String("LJ"));
            char_map.put(new Character('\u01c8'), new String("Lj"));
            char_map.put(new Character('\u01c9'), new String("lj"));
            char_map.put(new Character('\u01ca'), new String("NJ"));
            char_map.put(new Character('\u01cb'), new String("Nj"));
            char_map.put(new Character('\u01cc'), new String("nj"));
            char_map.put(new Character('\u01cd'), new String("A"));
            char_map.put(new Character('\u01ce'), new String("a"));
            char_map.put(new Character('\u01cf'), new String("I"));
            char_map.put(new Character('\u01d0'), new String("i"));
            char_map.put(new Character('\u01d1'), new String("O"));
            char_map.put(new Character('\u01d2'), new String("o"));
            char_map.put(new Character('\u01d3'), new String("U"));
            char_map.put(new Character('\u01d4'), new String("u"));
            char_map.put(new Character('\u01d5'), new String("U"));
            char_map.put(new Character('\u01d6'), new String("u"));
            char_map.put(new Character('\u01d7'), new String("U"));
            char_map.put(new Character('\u01d8'), new String("u"));
            char_map.put(new Character('\u01d9'), new String("U"));
            char_map.put(new Character('\u01da'), new String("u"));
            char_map.put(new Character('\u01db'), new String("U"));
            char_map.put(new Character('\u01dc'), new String("u"));
            char_map.put(new Character('\u01dd'), new String("e"));
            char_map.put(new Character('\u01de'), new String("A"));
            char_map.put(new Character('\u01df'), new String("a"));
            char_map.put(new Character('\u01e0'), new String("A"));
            char_map.put(new Character('\u01e1'), new String("a"));
            char_map.put(new Character('\u01e2'), new String("AE"));
            char_map.put(new Character('\u01e3'), new String("ae"));
            char_map.put(new Character('\u01e4'), new String("G"));
            char_map.put(new Character('\u01e5'), new String("g"));
            char_map.put(new Character('\u01e6'), new String("G"));
            char_map.put(new Character('\u01e7'), new String("g"));
            char_map.put(new Character('\u01e8'), new String("K"));
            char_map.put(new Character('\u01e9'), new String("k"));
            char_map.put(new Character('\u01ea'), new String("O"));
            char_map.put(new Character('\u01eb'), new String("o"));
            char_map.put(new Character('\u01ec'), new String("O"));
            char_map.put(new Character('\u01ed'), new String("o"));
            char_map.put(new Character('\u01f0'), new String("j"));
            char_map.put(new Character('\u01f1'), new String("DZ"));
            char_map.put(new Character('\u01f2'), new String("Dz"));
            char_map.put(new Character('\u01f3'), new String("dz"));
            char_map.put(new Character('\u01f4'), new String("G"));
            char_map.put(new Character('\u01f5'), new String("g"));
            char_map.put(new Character('\u01f8'), new String("N"));
            char_map.put(new Character('\u01f9'), new String("n"));
            char_map.put(new Character('\u01fa'), new String("A"));
            char_map.put(new Character('\u01fb'), new String("a"));
            char_map.put(new Character('\u01fc'), new String("AE"));
            char_map.put(new Character('\u01fd'), new String("ae"));
            char_map.put(new Character('\u01fe'), new String("O"));
            char_map.put(new Character('\u01ff'), new String("o"));
            char_map.put(new Character('\u0200'), new String("A"));
            char_map.put(new Character('\u0201'), new String("a"));
            char_map.put(new Character('\u0202'), new String("A"));
            char_map.put(new Character('\u0203'), new String("a"));
            char_map.put(new Character('\u0204'), new String("E"));
            char_map.put(new Character('\u0205'), new String("e"));
            char_map.put(new Character('\u0206'), new String("E"));
            char_map.put(new Character('\u0207'), new String("e"));
            char_map.put(new Character('\u0208'), new String("I"));
            char_map.put(new Character('\u0209'), new String("i"));
            char_map.put(new Character('\u020a'), new String("I"));
            char_map.put(new Character('\u020b'), new String("i"));
            char_map.put(new Character('\u020c'), new String("O"));
            char_map.put(new Character('\u020d'), new String("o"));
            char_map.put(new Character('\u020e'), new String("O"));
            char_map.put(new Character('\u020f'), new String("o"));
            char_map.put(new Character('\u0210'), new String("R"));
            char_map.put(new Character('\u0211'), new String("r"));
            char_map.put(new Character('\u0212'), new String("R"));
            char_map.put(new Character('\u0213'), new String("r"));
            char_map.put(new Character('\u0214'), new String("U"));
            char_map.put(new Character('\u0215'), new String("u"));
            char_map.put(new Character('\u0216'), new String("U"));
            char_map.put(new Character('\u0217'), new String("u"));
            char_map.put(new Character('\u0218'), new String("S"));
            char_map.put(new Character('\u0219'), new String("s"));
            char_map.put(new Character('\u021a'), new String("T"));
            char_map.put(new Character('\u021b'), new String("t"));
            char_map.put(new Character('\u021e'), new String("H"));
            char_map.put(new Character('\u021f'), new String("h"));
            char_map.put(new Character('\u0220'), new String("N"));
            char_map.put(new Character('\u0221'), new String("d"));
            char_map.put(new Character('\u0222'), new String("OU"));
            char_map.put(new Character('\u0223'), new String("ou"));
            char_map.put(new Character('\u0224'), new String("Z"));
            char_map.put(new Character('\u0225'), new String("z"));
            char_map.put(new Character('\u0226'), new String("A"));
            char_map.put(new Character('\u0227'), new String("a"));
            char_map.put(new Character('\u0228'), new String("E"));
            char_map.put(new Character('\u0229'), new String("e"));
            char_map.put(new Character('\u022a'), new String("O"));
            char_map.put(new Character('\u022b'), new String("o"));
            char_map.put(new Character('\u022c'), new String("O"));
            char_map.put(new Character('\u022d'), new String("o"));
            char_map.put(new Character('\u022e'), new String("O"));
            char_map.put(new Character('\u022f'), new String("o"));
            char_map.put(new Character('\u0230'), new String("O"));
            char_map.put(new Character('\u0231'), new String("o"));
            char_map.put(new Character('\u0232'), new String("Y"));
            char_map.put(new Character('\u0233'), new String("y"));
            char_map.put(new Character('\u0234'), new String("l"));
            char_map.put(new Character('\u0235'), new String("n"));
            char_map.put(new Character('\u0236'), new String("t"));
            char_map.put(new Character('\u0237'), new String("j"));
            char_map.put(new Character('\u0238'), new String("db"));
            char_map.put(new Character('\u0239'), new String("qp"));
            char_map.put(new Character('\u023a'), new String("A"));
            char_map.put(new Character('\u023b'), new String("C"));
            char_map.put(new Character('\u023c'), new String("c"));
            char_map.put(new Character('\u023d'), new String("L"));
            char_map.put(new Character('\u023e'), new String("T"));
            char_map.put(new Character('\u023f'), new String("s"));
            char_map.put(new Character('\u0240'), new String("z"));
            char_map.put(new Character('\u0243'), new String("B"));
            char_map.put(new Character('\u0244'), new String("U"));
            char_map.put(new Character('\u0245'), new String("V"));
            char_map.put(new Character('\u0246'), new String("E"));
            char_map.put(new Character('\u0247'), new String("e"));
            char_map.put(new Character('\u0248'), new String("J"));
            char_map.put(new Character('\u0249'), new String("j"));
            char_map.put(new Character('\u024a'), new String("Q"));
            char_map.put(new Character('\u024b'), new String("q"));
            char_map.put(new Character('\u024c'), new String("R"));
            char_map.put(new Character('\u024d'), new String("r"));
            char_map.put(new Character('\u024e'), new String("Y"));
            char_map.put(new Character('\u024f'), new String("y"));
            char_map.put(new Character('\u0250'), new String("a"));
            char_map.put(new Character('\u0251'), new String("alpha"));
            char_map.put(new Character('\u0252'), new String("alpha"));
            char_map.put(new Character('\u0253'), new String("b"));
            char_map.put(new Character('\u0254'), new String("o"));
            char_map.put(new Character('\u0255'), new String("c"));
            char_map.put(new Character('\u0256'), new String("d"));
            char_map.put(new Character('\u0257'), new String("d"));
            char_map.put(new Character('\u025b'), new String("E"));
            char_map.put(new Character('\u025f'), new String("j"));
            char_map.put(new Character('\u0260'), new String("g"));
            char_map.put(new Character('\u0261'), new String("g"));
            char_map.put(new Character('\u0262'), new String("G"));
            char_map.put(new Character('\u0263'), new String("gamma"));
            char_map.put(new Character('\u0265'), new String("h"));
            char_map.put(new Character('\u0266'), new String("h"));
            char_map.put(new Character('\u0268'), new String("i"));
            char_map.put(new Character('\u0269'), new String("iota"));
            char_map.put(new Character('\u026a'), new String("i"));
            char_map.put(new Character('\u026b'), new String("l"));
            char_map.put(new Character('\u026c'), new String("l"));
            char_map.put(new Character('\u026d'), new String("l"));
            char_map.put(new Character('\u026f'), new String("m"));
            char_map.put(new Character('\u0270'), new String("m"));
            char_map.put(new Character('\u0271'), new String("m"));
            char_map.put(new Character('\u0272'), new String("n"));
            char_map.put(new Character('\u0273'), new String("n"));
            char_map.put(new Character('\u0274'), new String("N"));
            char_map.put(new Character('\u0275'), new String("o"));
            char_map.put(new Character('\u0276'), new String("OE"));
            char_map.put(new Character('\u0277'), new String("omega"));
            char_map.put(new Character('\u0278'), new String("phi"));
            char_map.put(new Character('\u0279'), new String("r"));
            char_map.put(new Character('\u027a'), new String("r"));
            char_map.put(new Character('\u027b'), new String("r"));
            char_map.put(new Character('\u027c'), new String("r"));
            char_map.put(new Character('\u027d'), new String("r"));
            char_map.put(new Character('\u027e'), new String("r"));
            char_map.put(new Character('\u0280'), new String("R"));
            char_map.put(new Character('\u0282'), new String("s"));
            char_map.put(new Character('\u0284'), new String("j"));
            char_map.put(new Character('\u0287'), new String("t"));
            char_map.put(new Character('\u0288'), new String("t"));
            char_map.put(new Character('\u0289'), new String("u"));
            char_map.put(new Character('\u028a'), new String("upsilon"));
            char_map.put(new Character('\u028b'), new String("v"));
            char_map.put(new Character('\u028c'), new String("v"));
            char_map.put(new Character('\u028d'), new String("w"));
            char_map.put(new Character('\u028e'), new String("y"));
            char_map.put(new Character('\u028f'), new String("Y"));
            char_map.put(new Character('\u0290'), new String("z"));
            char_map.put(new Character('\u0291'), new String("z"));
            char_map.put(new Character('\u0297'), new String("C"));
            char_map.put(new Character('\u0299'), new String("B"));
            char_map.put(new Character('\u029a'), new String("e"));
            char_map.put(new Character('\u029b'), new String("G"));
            char_map.put(new Character('\u029c'), new String("H"));
            char_map.put(new Character('\u029d'), new String("j"));
            char_map.put(new Character('\u029e'), new String("k"));
            char_map.put(new Character('\u029f'), new String("L"));
            char_map.put(new Character('\u02a0'), new String("q"));
            char_map.put(new Character('\u02a3'), new String("DZ"));
            char_map.put(new Character('\u02a5'), new String("dz"));
            char_map.put(new Character('\u02a6'), new String("ts"));
            char_map.put(new Character('\u02a8'), new String("tc"));
            char_map.put(new Character('\u02aa'), new String("ls"));
            char_map.put(new Character('\u02ab'), new String("lz"));
            char_map.put(new Character('\u02ae'), new String("h"));
            char_map.put(new Character('\u02af'), new String("h"));
            char_map.put(new Character('\u02c6'), new String("^"));
            char_map.put(new Character('\u02dc'), new String("~"));
            char_map.put(new Character('\u037e'), new String(";"));
            char_map.put(new Character('\u0386'), new String("Alpha"));
            char_map.put(new Character('\u0388'), new String("Epsilon"));
            char_map.put(new Character('\u0389'), new String("Eta"));
            char_map.put(new Character('\u038a'), new String("Iota"));
            char_map.put(new Character('\u038c'), new String("Omicron"));
            char_map.put(new Character('\u038e'), new String("Upsilon"));
            char_map.put(new Character('\u038f'), new String("Omega"));
            char_map.put(new Character('\u0390'), new String("iota"));
            char_map.put(new Character('\u0391'), new String("Alpha"));
            char_map.put(new Character('\u0392'), new String("Beta"));
            char_map.put(new Character('\u0393'), new String("Gamma"));
            char_map.put(new Character('\u0394'), new String("Delta"));
            char_map.put(new Character('\u0395'), new String("Epsilon"));
            char_map.put(new Character('\u0396'), new String("Zeta"));
            char_map.put(new Character('\u0397'), new String("Eta"));
            char_map.put(new Character('\u0398'), new String("Theta"));
            char_map.put(new Character('\u0399'), new String("Iota"));
            char_map.put(new Character('\u039a'), new String("Kappa"));
            char_map.put(new Character('\u039b'), new String("Lambda"));
            char_map.put(new Character('\u039c'), new String("Mu"));
            char_map.put(new Character('\u039d'), new String("Nu"));
            char_map.put(new Character('\u039e'), new String("Xi"));
            char_map.put(new Character('\u039f'), new String("Omicron"));
            char_map.put(new Character('\u03a0'), new String("Pi"));
            char_map.put(new Character('\u03a1'), new String("Rho"));
            char_map.put(new Character('\u03a3'), new String("Sigma"));
            char_map.put(new Character('\u03a4'), new String("Tau"));
            char_map.put(new Character('\u03a5'), new String("Upsilon"));
            char_map.put(new Character('\u03a6'), new String("Phi"));
            char_map.put(new Character('\u03a7'), new String("Chi"));
            char_map.put(new Character('\u03a8'), new String("Psi"));
            char_map.put(new Character('\u03a9'), new String("Omega"));
            char_map.put(new Character('\u03aa'), new String("Iota"));
            char_map.put(new Character('\u03ab'), new String("Upsilon"));
            char_map.put(new Character('\u03ac'), new String("alpha"));
            char_map.put(new Character('\u03ad'), new String("epsilon"));
            char_map.put(new Character('\u03ae'), new String("eta"));
            char_map.put(new Character('\u03af'), new String("iota"));
            char_map.put(new Character('\u03b0'), new String("upsilon"));
            char_map.put(new Character('\u03b1'), new String("alpha"));
            char_map.put(new Character('\u03b2'), new String("beta"));
            char_map.put(new Character('\u03b3'), new String("gamma"));
            char_map.put(new Character('\u03b4'), new String("delta"));
            char_map.put(new Character('\u03b5'), new String("epsilon"));
            char_map.put(new Character('\u03b6'), new String("zeta"));
            char_map.put(new Character('\u03b7'), new String("eta"));
            char_map.put(new Character('\u03b8'), new String("theta"));
            char_map.put(new Character('\u03b9'), new String("iota"));
            char_map.put(new Character('\u03ba'), new String("kappa"));
            char_map.put(new Character('\u03bb'), new String("lambda"));
            char_map.put(new Character('\u03bc'), new String("mu"));
            char_map.put(new Character('\u03bd'), new String("nu"));
            char_map.put(new Character('\u03be'), new String("xi"));
            char_map.put(new Character('\u03bf'), new String("omicron"));
            char_map.put(new Character('\u03c0'), new String("pi"));
            char_map.put(new Character('\u03c1'), new String("rho"));
            char_map.put(new Character('\u03c2'), new String("sigma"));
            char_map.put(new Character('\u03c3'), new String("sigma"));
            char_map.put(new Character('\u03c4'), new String("tau"));
            char_map.put(new Character('\u03c5'), new String("upsilon"));
            char_map.put(new Character('\u03c6'), new String("phi"));
            char_map.put(new Character('\u03c7'), new String("chi"));
            char_map.put(new Character('\u03c8'), new String("psi"));
            char_map.put(new Character('\u03c9'), new String("omega"));
            char_map.put(new Character('\u03ca'), new String("iota"));
            char_map.put(new Character('\u03cb'), new String("upsilon"));
            char_map.put(new Character('\u03cc'), new String("omicron"));
            char_map.put(new Character('\u03cd'), new String("upsilon"));
            char_map.put(new Character('\u03ce'), new String("omega"));
            char_map.put(new Character('\u03d0'), new String("beta"));
            char_map.put(new Character('\u03d1'), new String("theta"));
            char_map.put(new Character('\u03d2'), new String("Upsilon"));
            char_map.put(new Character('\u03d3'), new String("Upsilon"));
            char_map.put(new Character('\u03d4'), new String("Upsilon"));
            char_map.put(new Character('\u03d5'), new String("phi"));
            char_map.put(new Character('\u03d6'), new String("pi"));
            char_map.put(new Character('\u03f0'), new String("kappa"));
            char_map.put(new Character('\u03f1'), new String("rho"));
            char_map.put(new Character('\u03f2'), new String("sigma"));
            char_map.put(new Character('\u03f4'), new String("Theta"));
            char_map.put(new Character('\u03f5'), new String("epsilon"));
            char_map.put(new Character('\u03f9'), new String("Sigma"));
            char_map.put(new Character('\u03fc'), new String("Rho"));
            char_map.put(new Character('\u1e00'), new String("A"));
            char_map.put(new Character('\u1e01'), new String("a"));
            char_map.put(new Character('\u1e02'), new String("B"));
            char_map.put(new Character('\u1e03'), new String("b"));
            char_map.put(new Character('\u1e04'), new String("B"));
            char_map.put(new Character('\u1e05'), new String("b"));
            char_map.put(new Character('\u1e06'), new String("B"));
            char_map.put(new Character('\u1e07'), new String("b"));
            char_map.put(new Character('\u1e08'), new String("C"));
            char_map.put(new Character('\u1e09'), new String("c"));
            char_map.put(new Character('\u1e0a'), new String("D"));
            char_map.put(new Character('\u1e0b'), new String("d"));
            char_map.put(new Character('\u1e0c'), new String("D"));
            char_map.put(new Character('\u1e0d'), new String("d"));
            char_map.put(new Character('\u1e0e'), new String("D"));
            char_map.put(new Character('\u1e0f'), new String("d"));
            char_map.put(new Character('\u1e10'), new String("D"));
            char_map.put(new Character('\u1e11'), new String("d"));
            char_map.put(new Character('\u1e12'), new String("D"));
            char_map.put(new Character('\u1e13'), new String("d"));
            char_map.put(new Character('\u1e14'), new String("E"));
            char_map.put(new Character('\u1e15'), new String("e"));
            char_map.put(new Character('\u1e16'), new String("E"));
            char_map.put(new Character('\u1e17'), new String("e"));
            char_map.put(new Character('\u1e18'), new String("E"));
            char_map.put(new Character('\u1e19'), new String("e"));
            char_map.put(new Character('\u1e1a'), new String("E"));
            char_map.put(new Character('\u1e1b'), new String("e"));
            char_map.put(new Character('\u1e1c'), new String("E"));
            char_map.put(new Character('\u1e1d'), new String("e"));
            char_map.put(new Character('\u1e1e'), new String("F"));
            char_map.put(new Character('\u1e1f'), new String("f"));
            char_map.put(new Character('\u1e20'), new String("G"));
            char_map.put(new Character('\u1e21'), new String("g"));
            char_map.put(new Character('\u1e22'), new String("H"));
            char_map.put(new Character('\u1e23'), new String("h"));
            char_map.put(new Character('\u1e24'), new String("H"));
            char_map.put(new Character('\u1e25'), new String("h"));
            char_map.put(new Character('\u1e26'), new String("H"));
            char_map.put(new Character('\u1e27'), new String("h"));
            char_map.put(new Character('\u1e28'), new String("H"));
            char_map.put(new Character('\u1e29'), new String("h"));
            char_map.put(new Character('\u1e2a'), new String("H"));
            char_map.put(new Character('\u1e2b'), new String("h"));
            char_map.put(new Character('\u1e2c'), new String("I"));
            char_map.put(new Character('\u1e2d'), new String("i"));
            char_map.put(new Character('\u1e2e'), new String("I"));
            char_map.put(new Character('\u1e2f'), new String("i"));
            char_map.put(new Character('\u1e30'), new String("K"));
            char_map.put(new Character('\u1e31'), new String("k"));
            char_map.put(new Character('\u1e32'), new String("K"));
            char_map.put(new Character('\u1e33'), new String("k"));
            char_map.put(new Character('\u1e34'), new String("K"));
            char_map.put(new Character('\u1e35'), new String("k"));
            char_map.put(new Character('\u1e36'), new String("L"));
            char_map.put(new Character('\u1e37'), new String("l"));
            char_map.put(new Character('\u1e38'), new String("L"));
            char_map.put(new Character('\u1e39'), new String("l"));
            char_map.put(new Character('\u1e3a'), new String("L"));
            char_map.put(new Character('\u1e3b'), new String("l"));
            char_map.put(new Character('\u1e3c'), new String("L"));
            char_map.put(new Character('\u1e3d'), new String("l"));
            char_map.put(new Character('\u1e3e'), new String("M"));
            char_map.put(new Character('\u1e3f'), new String("m"));
            char_map.put(new Character('\u1e40'), new String("M"));
            char_map.put(new Character('\u1e41'), new String("m"));
            char_map.put(new Character('\u1e42'), new String("M"));
            char_map.put(new Character('\u1e43'), new String("m"));
            char_map.put(new Character('\u1e44'), new String("N"));
            char_map.put(new Character('\u1e45'), new String("n"));
            char_map.put(new Character('\u1e46'), new String("N"));
            char_map.put(new Character('\u1e47'), new String("n"));
            char_map.put(new Character('\u1e48'), new String("N"));
            char_map.put(new Character('\u1e49'), new String("n"));
            char_map.put(new Character('\u1e4a'), new String("N"));
            char_map.put(new Character('\u1e4b'), new String("n"));
            char_map.put(new Character('\u1e4c'), new String("O"));
            char_map.put(new Character('\u1e4d'), new String("o"));
            char_map.put(new Character('\u1e4e'), new String("O"));
            char_map.put(new Character('\u1e4f'), new String("o"));
            char_map.put(new Character('\u1e50'), new String("O"));
            char_map.put(new Character('\u1e51'), new String("o"));
            char_map.put(new Character('\u1e52'), new String("O"));
            char_map.put(new Character('\u1e53'), new String("o"));
            char_map.put(new Character('\u1e54'), new String("P"));
            char_map.put(new Character('\u1e55'), new String("p"));
            char_map.put(new Character('\u1e56'), new String("P"));
            char_map.put(new Character('\u1e57'), new String("p"));
            char_map.put(new Character('\u1e58'), new String("R"));
            char_map.put(new Character('\u1e59'), new String("r"));
            char_map.put(new Character('\u1e5a'), new String("R"));
            char_map.put(new Character('\u1e5b'), new String("r"));
            char_map.put(new Character('\u1e5c'), new String("R"));
            char_map.put(new Character('\u1e5d'), new String("r"));
            char_map.put(new Character('\u1e5e'), new String("R"));
            char_map.put(new Character('\u1e5f'), new String("r"));
            char_map.put(new Character('\u1e60'), new String("S"));
            char_map.put(new Character('\u1e61'), new String("s"));
            char_map.put(new Character('\u1e62'), new String("S"));
            char_map.put(new Character('\u1e63'), new String("s"));
            char_map.put(new Character('\u1e64'), new String("S"));
            char_map.put(new Character('\u1e65'), new String("s"));
            char_map.put(new Character('\u1e66'), new String("S"));
            char_map.put(new Character('\u1e67'), new String("s"));
            char_map.put(new Character('\u1e68'), new String("S"));
            char_map.put(new Character('\u1e69'), new String("s"));
            char_map.put(new Character('\u1e6a'), new String("T"));
            char_map.put(new Character('\u1e6b'), new String("t"));
            char_map.put(new Character('\u1e6c'), new String("T"));
            char_map.put(new Character('\u1e6d'), new String("t"));
            char_map.put(new Character('\u1e6e'), new String("T"));
            char_map.put(new Character('\u1e6f'), new String("t"));
            char_map.put(new Character('\u1e70'), new String("T"));
            char_map.put(new Character('\u1e71'), new String("t"));
            char_map.put(new Character('\u1e72'), new String("U"));
            char_map.put(new Character('\u1e73'), new String("u"));
            char_map.put(new Character('\u1e74'), new String("U"));
            char_map.put(new Character('\u1e75'), new String("u"));
            char_map.put(new Character('\u1e76'), new String("U"));
            char_map.put(new Character('\u1e77'), new String("u"));
            char_map.put(new Character('\u1e78'), new String("U"));
            char_map.put(new Character('\u1e79'), new String("u"));
            char_map.put(new Character('\u1e7a'), new String("U"));
            char_map.put(new Character('\u1e7b'), new String("u"));
            char_map.put(new Character('\u1e7c'), new String("V"));
            char_map.put(new Character('\u1e7d'), new String("v"));
            char_map.put(new Character('\u1e7e'), new String("V"));
            char_map.put(new Character('\u1e7f'), new String("v"));
            char_map.put(new Character('\u1e80'), new String("W"));
            char_map.put(new Character('\u1e81'), new String("w"));
            char_map.put(new Character('\u1e82'), new String("W"));
            char_map.put(new Character('\u1e83'), new String("w"));
            char_map.put(new Character('\u1e84'), new String("W"));
            char_map.put(new Character('\u1e85'), new String("w"));
            char_map.put(new Character('\u1e86'), new String("W"));
            char_map.put(new Character('\u1e87'), new String("w"));
            char_map.put(new Character('\u1e88'), new String("W"));
            char_map.put(new Character('\u1e89'), new String("w"));
            char_map.put(new Character('\u1e8a'), new String("X"));
            char_map.put(new Character('\u1e8b'), new String("x"));
            char_map.put(new Character('\u1e8c'), new String("X"));
            char_map.put(new Character('\u1e8d'), new String("x"));
            char_map.put(new Character('\u1e8e'), new String("Y"));
            char_map.put(new Character('\u1e8f'), new String("y"));
            char_map.put(new Character('\u1e90'), new String("Z"));
            char_map.put(new Character('\u1e91'), new String("z"));
            char_map.put(new Character('\u1e92'), new String("Z"));
            char_map.put(new Character('\u1e93'), new String("z"));
            char_map.put(new Character('\u1e94'), new String("Z"));
            char_map.put(new Character('\u1e95'), new String("z"));
            char_map.put(new Character('\u1e96'), new String("h"));
            char_map.put(new Character('\u1e97'), new String("t"));
            char_map.put(new Character('\u1e98'), new String("w"));
            char_map.put(new Character('\u1e99'), new String("y"));
            char_map.put(new Character('\u1e9a'), new String("a"));
            char_map.put(new Character('\u1e9b'), new String("s"));
            char_map.put(new Character('\u1ea0'), new String("A"));
            char_map.put(new Character('\u1ea1'), new String("a"));
            char_map.put(new Character('\u1ea2'), new String("A"));
            char_map.put(new Character('\u1ea3'), new String("a"));
            char_map.put(new Character('\u1ea4'), new String("A"));
            char_map.put(new Character('\u1ea5'), new String("a"));
            char_map.put(new Character('\u1ea6'), new String("A"));
            char_map.put(new Character('\u1ea7'), new String("a"));
            char_map.put(new Character('\u1ea8'), new String("A"));
            char_map.put(new Character('\u1ea9'), new String("a"));
            char_map.put(new Character('\u1eaa'), new String("A"));
            char_map.put(new Character('\u1eab'), new String("a"));
            char_map.put(new Character('\u1eac'), new String("A"));
            char_map.put(new Character('\u1ead'), new String("a"));
            char_map.put(new Character('\u1eae'), new String("A"));
            char_map.put(new Character('\u1eaf'), new String("a"));
            char_map.put(new Character('\u1eb0'), new String("A"));
            char_map.put(new Character('\u1eb1'), new String("a"));
            char_map.put(new Character('\u1eb2'), new String("A"));
            char_map.put(new Character('\u1eb3'), new String("a"));
            char_map.put(new Character('\u1eb4'), new String("A"));
            char_map.put(new Character('\u1eb5'), new String("a"));
            char_map.put(new Character('\u1eb6'), new String("A"));
            char_map.put(new Character('\u1eb7'), new String("a"));
            char_map.put(new Character('\u1eb8'), new String("E"));
            char_map.put(new Character('\u1eb9'), new String("e"));
            char_map.put(new Character('\u1eba'), new String("E"));
            char_map.put(new Character('\u1ebb'), new String("e"));
            char_map.put(new Character('\u1ebc'), new String("E"));
            char_map.put(new Character('\u1ebd'), new String("e"));
            char_map.put(new Character('\u1ebe'), new String("E"));
            char_map.put(new Character('\u1ebf'), new String("e"));
            char_map.put(new Character('\u1ec0'), new String("E"));
            char_map.put(new Character('\u1ec1'), new String("e"));
            char_map.put(new Character('\u1ec2'), new String("E"));
            char_map.put(new Character('\u1ec3'), new String("e"));
            char_map.put(new Character('\u1ec4'), new String("E"));
            char_map.put(new Character('\u1ec5'), new String("e"));
            char_map.put(new Character('\u1ec6'), new String("E"));
            char_map.put(new Character('\u1ec7'), new String("e"));
            char_map.put(new Character('\u1ec8'), new String("I"));
            char_map.put(new Character('\u1ec9'), new String("i"));
            char_map.put(new Character('\u1eca'), new String("I"));
            char_map.put(new Character('\u1ecb'), new String("i"));
            char_map.put(new Character('\u1ecc'), new String("O"));
            char_map.put(new Character('\u1ecd'), new String("o"));
            char_map.put(new Character('\u1ece'), new String("O"));
            char_map.put(new Character('\u1ecf'), new String("o"));
            char_map.put(new Character('\u1ed0'), new String("O"));
            char_map.put(new Character('\u1ed1'), new String("o"));
            char_map.put(new Character('\u1ed2'), new String("O"));
            char_map.put(new Character('\u1ed3'), new String("o"));
            char_map.put(new Character('\u1ed4'), new String("O"));
            char_map.put(new Character('\u1ed5'), new String("o"));
            char_map.put(new Character('\u1ed6'), new String("O"));
            char_map.put(new Character('\u1ed7'), new String("o"));
            char_map.put(new Character('\u1ed8'), new String("O"));
            char_map.put(new Character('\u1ed9'), new String("o"));
            char_map.put(new Character('\u1eda'), new String("O"));
            char_map.put(new Character('\u1edb'), new String("o"));
            char_map.put(new Character('\u1edc'), new String("O"));
            char_map.put(new Character('\u1edd'), new String("o"));
            char_map.put(new Character('\u1ede'), new String("O"));
            char_map.put(new Character('\u1edf'), new String("o"));
            char_map.put(new Character('\u1ee0'), new String("O"));
            char_map.put(new Character('\u1ee1'), new String("o"));
            char_map.put(new Character('\u1ee2'), new String("O"));
            char_map.put(new Character('\u1ee3'), new String("o"));
            char_map.put(new Character('\u1ee4'), new String("U"));
            char_map.put(new Character('\u1ee5'), new String("u"));
            char_map.put(new Character('\u1ee6'), new String("U"));
            char_map.put(new Character('\u1ee7'), new String("u"));
            char_map.put(new Character('\u1ee8'), new String("U"));
            char_map.put(new Character('\u1ee9'), new String("u"));
            char_map.put(new Character('\u1eea'), new String("U"));
            char_map.put(new Character('\u1eeb'), new String("u"));
            char_map.put(new Character('\u1eec'), new String("U"));
            char_map.put(new Character('\u1eed'), new String("u"));
            char_map.put(new Character('\u1eee'), new String("U"));
            char_map.put(new Character('\u1eef'), new String("u"));
            char_map.put(new Character('\u1ef0'), new String("U"));
            char_map.put(new Character('\u1ef1'), new String("u"));
            char_map.put(new Character('\u1ef2'), new String("Y"));
            char_map.put(new Character('\u1ef3'), new String("y"));
            char_map.put(new Character('\u1ef4'), new String("Y"));
            char_map.put(new Character('\u1ef5'), new String("y"));
            char_map.put(new Character('\u1ef6'), new String("Y"));
            char_map.put(new Character('\u1ef7'), new String("y"));
            char_map.put(new Character('\u1ef8'), new String("Y"));
            char_map.put(new Character('\u1ef9'), new String("y"));
            char_map.put(new Character('\u2002'), new String(" "));
            char_map.put(new Character('\u2003'), new String(" "));
            char_map.put(new Character('\u2009'), new String(" "));
            char_map.put(new Character('\u2010'), new String("-"));
            char_map.put(new Character('\u2011'), new String("-"));
            char_map.put(new Character('\u2012'), new String("-"));
            char_map.put(new Character('\u2013'), new String("-"));
            char_map.put(new Character('\u2014'), new String("-"));
            char_map.put(new Character('\u2015'), new String("--"));
            char_map.put(new Character('\u2016'), new String("||"));
            char_map.put(new Character('\u2017'), new String("_"));
            char_map.put(new Character('\u2018'), new String("'"));
            char_map.put(new Character('\u2019'), new String("'"));
            char_map.put(new Character('\u201a'), new String(","));
            char_map.put(new Character('\u201b'), new String("'"));
            char_map.put(new Character('\u2024'), new String("."));
            char_map.put(new Character('\u2025'), new String(".."));
            char_map.put(new Character('\u2026'), new String("..."));
            char_map.put(new Character('\u202f'), new String(" "));
            char_map.put(new Character('\u2030'), new String("0/00"));
            char_map.put(new Character('\u2031'), new String("0/000"));
            char_map.put(new Character('\u2032'), new String("'"));
            char_map.put(new Character('\u2034'), new String("'''"));
            char_map.put(new Character('\u2035'), new String("`"));
            char_map.put(new Character('\u2037'), new String("'''"));
            char_map.put(new Character('\u2038'), new String("^"));
            char_map.put(new Character('\u2039'), new String("<"));
            char_map.put(new Character('\u203a'), new String(">"));
            char_map.put(new Character('\u203c'), new String("!!"));
            char_map.put(new Character('\u203d'), new String("?"));
            char_map.put(new Character('\u2044'), new String("/"));
            char_map.put(new Character('\u2045'), new String("["));
            char_map.put(new Character('\u2046'), new String("]"));
            char_map.put(new Character('\u2047'), new String("??"));
            char_map.put(new Character('\u2048'), new String("?!"));
            char_map.put(new Character('\u2049'), new String("!?"));
            char_map.put(new Character('\u204e'), new String("*"));
            char_map.put(new Character('\u2052'), new String("%"));
            char_map.put(new Character('\u2053'), new String("~"));
            char_map.put(new Character('\u2056'), new String("..."));
            char_map.put(new Character('\u2057'), new String("''''"));
            char_map.put(new Character('\u2058'), new String("...."));
            char_map.put(new Character('\u2059'), new String("....."));
            char_map.put(new Character('\u205a'), new String(".."));
            char_map.put(new Character('\u205f'), new String(" "));

            char_map.put(new Character('\u2070'), new String("0")); // superscript 0
            char_map.put(new Character('\u2071'), new String("i"));
            char_map.put(new Character('\u2072'), new String("2"));
            char_map.put(new Character('\u2073'), new String("3"));
            char_map.put(new Character('\u2074'), new String("4"));
            char_map.put(new Character('\u2075'), new String("5"));
            char_map.put(new Character('\u2076'), new String("6"));
            char_map.put(new Character('\u2077'), new String("7"));
            char_map.put(new Character('\u2078'), new String("8"));
            char_map.put(new Character('\u2079'), new String("9"));
            char_map.put(new Character('\u207A'), new String("+"));
            char_map.put(new Character('\u207B'), new String("-"));
            char_map.put(new Character('\u207C'), new String("="));
            char_map.put(new Character('\u207D'), new String("("));
            char_map.put(new Character('\u207E'), new String(")"));
            char_map.put(new Character('\u207F'), new String("n"));

            char_map.put(new Character('\u2080'), new String("0")); // subscript 0
            char_map.put(new Character('\u2081'), new String("1")); // subscript 1
            char_map.put(new Character('\u2082'), new String("2")); // subscript 2
            char_map.put(new Character('\u2083'), new String("3")); // subscript 3
            char_map.put(new Character('\u2084'), new String("4")); // subscript 4
            char_map.put(new Character('\u2085'), new String("5")); // subscript 5
            char_map.put(new Character('\u2086'), new String("6")); // subscript 6
            char_map.put(new Character('\u2087'), new String("7")); // subscript 7
            char_map.put(new Character('\u2088'), new String("8")); // subscript 8
            char_map.put(new Character('\u2089'), new String("9")); // subscript 9
            char_map.put(new Character('\u208A'), new String("+"));
            char_map.put(new Character('\u208B'), new String("-"));
            char_map.put(new Character('\u208C'), new String("="));
            char_map.put(new Character('\u208D'), new String("("));
            char_map.put(new Character('\u208E'), new String(")"));
            char_map.put(new Character('\u2090'), new String("a"));
            char_map.put(new Character('\u2091'), new String("e"));
            char_map.put(new Character('\u2092'), new String("o"));
            char_map.put(new Character('\u2093'), new String("x"));
            char_map.put(new Character('\u2094'), new String("e")); // subscript schwa
            char_map.put(new Character('\u2095'), new String("h"));
            char_map.put(new Character('\u2096'), new String("k"));
            char_map.put(new Character('\u2097'), new String("l"));
            char_map.put(new Character('\u2098'), new String("m"));
            char_map.put(new Character('\u2099'), new String("n"));
            char_map.put(new Character('\u209A'), new String("p"));
            char_map.put(new Character('\u209B'), new String("s"));
            char_map.put(new Character('\u209C'), new String("t"));

            char_map.put(new Character('\u2100'), new String("a/c"));
            char_map.put(new Character('\u2101'), new String("a/s"));
            char_map.put(new Character('\u2102'), new String("C"));
            char_map.put(new Character('\u2103'), new String("C"));
            char_map.put(new Character('\u2105'), new String("c/o"));
            char_map.put(new Character('\u2106'), new String("c/u"));
            char_map.put(new Character('\u2107'), new String("E"));
            char_map.put(new Character('\u2109'), new String("F"));
            char_map.put(new Character('\u210a'), new String("g"));
            char_map.put(new Character('\u210b'), new String("H"));
            char_map.put(new Character('\u210c'), new String("H"));
            char_map.put(new Character('\u210d'), new String("H"));
            char_map.put(new Character('\u210e'), new String("h"));
            char_map.put(new Character('\u210f'), new String("h"));
            char_map.put(new Character('\u2110'), new String("I"));
            char_map.put(new Character('\u2111'), new String("I"));
            char_map.put(new Character('\u2112'), new String("L"));
            char_map.put(new Character('\u2113'), new String("l"));
            char_map.put(new Character('\u2115'), new String("N"));
            char_map.put(new Character('\u2116'), new String("No"));
            char_map.put(new Character('\u2117'), new String("(p)"));
            char_map.put(new Character('\u2118'), new String("P"));
            char_map.put(new Character('\u2119'), new String("P"));
            char_map.put(new Character('\u211a'), new String("Q"));
            char_map.put(new Character('\u211b'), new String("R"));
            char_map.put(new Character('\u211c'), new String("R"));
            char_map.put(new Character('\u211d'), new String("R"));
            char_map.put(new Character('\u211e'), new String("Px"));
            char_map.put(new Character('\u2120'), new String("SM"));
            char_map.put(new Character('\u2121'), new String("TEL"));
            char_map.put(new Character('\u2122'), new String("TM"));
            char_map.put(new Character('\u2124'), new String("Z"));
            char_map.put(new Character('\u2126'), new String("Omega"));
            char_map.put(new Character('\u2128'), new String("Z"));
            char_map.put(new Character('\u2129'), new String("iota"));
            char_map.put(new Character('\u212a'), new String("K"));
            char_map.put(new Character('\u212b'), new String("A"));
            char_map.put(new Character('\u212c'), new String("B"));
            char_map.put(new Character('\u212d'), new String("C"));
            char_map.put(new Character('\u212e'), new String("e"));
            char_map.put(new Character('\u212f'), new String("e"));
            char_map.put(new Character('\u2130'), new String("E"));
            char_map.put(new Character('\u2131'), new String("F"));
            char_map.put(new Character('\u2132'), new String("F"));
            char_map.put(new Character('\u2133'), new String("M"));
            char_map.put(new Character('\u2134'), new String("o"));
            char_map.put(new Character('\u2139'), new String("i"));
            char_map.put(new Character('\u213a'), new String("Q"));
            char_map.put(new Character('\u213b'), new String("FAX"));
            char_map.put(new Character('\u213c'), new String("pi"));
            char_map.put(new Character('\u213d'), new String("gamma"));
            char_map.put(new Character('\u213e'), new String("Gamma"));
            char_map.put(new Character('\u213f'), new String("PI"));
            char_map.put(new Character('\u2141'), new String("G"));
            char_map.put(new Character('\u2142'), new String("L"));
            char_map.put(new Character('\u2144'), new String("Y"));
            char_map.put(new Character('\u2145'), new String("D"));
            char_map.put(new Character('\u2146'), new String("d"));
            char_map.put(new Character('\u2147'), new String("e"));
            char_map.put(new Character('\u2148'), new String("i"));
            char_map.put(new Character('\u2149'), new String("j"));
            char_map.put(new Character('\u214b'), new String("&"));
            char_map.put(new Character('\u2153'), new String("1/3"));
            char_map.put(new Character('\u2154'), new String("2/3"));
            char_map.put(new Character('\u2155'), new String("1/5"));
            char_map.put(new Character('\u2156'), new String("2/5"));
            char_map.put(new Character('\u2157'), new String("3/5"));
            char_map.put(new Character('\u2158'), new String("4/5"));
            char_map.put(new Character('\u2159'), new String("1/6"));
            char_map.put(new Character('\u215a'), new String("5/6"));
            char_map.put(new Character('\u215b'), new String("1/8"));
            char_map.put(new Character('\u215c'), new String("3/8"));
            char_map.put(new Character('\u215d'), new String("5/8"));
            char_map.put(new Character('\u215e'), new String("7/8"));
            char_map.put(new Character('\u215f'), new String("1/"));
            char_map.put(new Character('\u2160'), new String("I"));
            char_map.put(new Character('\u2161'), new String("II"));
            char_map.put(new Character('\u2162'), new String("III"));
            char_map.put(new Character('\u2163'), new String("IV"));
            char_map.put(new Character('\u2164'), new String("V"));
            char_map.put(new Character('\u2165'), new String("VI"));
            char_map.put(new Character('\u2166'), new String("VII"));
            char_map.put(new Character('\u2167'), new String("VIII"));
            char_map.put(new Character('\u2168'), new String("IX"));
            char_map.put(new Character('\u2169'), new String("X"));
            char_map.put(new Character('\u216a'), new String("XI"));
            char_map.put(new Character('\u216b'), new String("XII"));
            char_map.put(new Character('\u216c'), new String("L"));
            char_map.put(new Character('\u216d'), new String("C"));
            char_map.put(new Character('\u216e'), new String("D"));
            char_map.put(new Character('\u216f'), new String("M"));
            char_map.put(new Character('\u2170'), new String("i"));
            char_map.put(new Character('\u2171'), new String("ii"));
            char_map.put(new Character('\u2172'), new String("iii"));
            char_map.put(new Character('\u2173'), new String("iv"));
            char_map.put(new Character('\u2174'), new String("v"));
            char_map.put(new Character('\u2175'), new String("vi"));
            char_map.put(new Character('\u2176'), new String("vii"));
            char_map.put(new Character('\u2177'), new String("viii"));
            char_map.put(new Character('\u2178'), new String("ix"));
            char_map.put(new Character('\u2179'), new String("x"));
            char_map.put(new Character('\u217a'), new String("xi"));
            char_map.put(new Character('\u217b'), new String("xii"));
            char_map.put(new Character('\u217c'), new String("l"));
            char_map.put(new Character('\u217d'), new String("c"));
            char_map.put(new Character('\u217e'), new String("d"));
            char_map.put(new Character('\u217f'), new String("m"));
            char_map.put(new Character('\u2180'), new String("CD"));
            char_map.put(new Character('\u2190'), new String("<-"));
            char_map.put(new Character('\u2192'), new String("->"));
            char_map.put(new Character('\u2194'), new String("<->"));
            char_map.put(new Character('\u219a'), new String("<-"));
            char_map.put(new Character('\u219b'), new String("->"));
            char_map.put(new Character('\u21ae'), new String("<->"));
            char_map.put(new Character('\u21cd'), new String("<="));
            char_map.put(new Character('\u21ce'), new String("<=>"));
            char_map.put(new Character('\u21cf'), new String("=>"));
            char_map.put(new Character('\u21d0'), new String("<="));
            char_map.put(new Character('\u21d2'), new String("=>"));
            char_map.put(new Character('\u21d4'), new String("<=>"));
            char_map.put(new Character('\u2303'), new String("^"));
            char_map.put(new Character('\u2329'), new String("<"));
            char_map.put(new Character('\u232a'), new String(">"));
            char_map.put(new Character('\u239b'), new String("("));
            char_map.put(new Character('\u239c'), new String("("));
            char_map.put(new Character('\u239d'), new String("("));
            char_map.put(new Character('\u239e'), new String(")"));
            char_map.put(new Character('\u239f'), new String(")"));
            char_map.put(new Character('\u23a0'), new String(")"));
            char_map.put(new Character('\u23a1'), new String("["));
            char_map.put(new Character('\u23a2'), new String("["));
            char_map.put(new Character('\u23a3'), new String("["));
            char_map.put(new Character('\u23a4'), new String("]"));
            char_map.put(new Character('\u23a5'), new String("]"));
            char_map.put(new Character('\u23a6'), new String("]"));
            char_map.put(new Character('\u23a7'), new String("{"));
            char_map.put(new Character('\u23a8'), new String("{"));
            char_map.put(new Character('\u23a9'), new String("{"));
            char_map.put(new Character('\u23ab'), new String("}"));
            char_map.put(new Character('\u23ac'), new String("}"));
            char_map.put(new Character('\u23ad'), new String("}"));
            char_map.put(new Character('\u2460'), new String("1"));
            char_map.put(new Character('\u2461'), new String("2"));
            char_map.put(new Character('\u2462'), new String("3"));
            char_map.put(new Character('\u2463'), new String("4"));
            char_map.put(new Character('\u2464'), new String("5"));
            char_map.put(new Character('\u2465'), new String("6"));
            char_map.put(new Character('\u2466'), new String("7"));
            char_map.put(new Character('\u2467'), new String("8"));
            char_map.put(new Character('\u2468'), new String("9"));
            char_map.put(new Character('\u2469'), new String("10"));
            char_map.put(new Character('\u246a'), new String("11"));
            char_map.put(new Character('\u246b'), new String("12"));
            char_map.put(new Character('\u246c'), new String("13"));
            char_map.put(new Character('\u246d'), new String("14"));
            char_map.put(new Character('\u246e'), new String("15"));
            char_map.put(new Character('\u246f'), new String("16"));
            char_map.put(new Character('\u2470'), new String("17"));
            char_map.put(new Character('\u2471'), new String("18"));
            char_map.put(new Character('\u2472'), new String("19"));
            char_map.put(new Character('\u2473'), new String("20"));
            char_map.put(new Character('\u2474'), new String("(1)"));
            char_map.put(new Character('\u2475'), new String("(2)"));
            char_map.put(new Character('\u2476'), new String("(3)"));
            char_map.put(new Character('\u2477'), new String("(4)"));
            char_map.put(new Character('\u2478'), new String("(5)"));
            char_map.put(new Character('\u2479'), new String("(6)"));
            char_map.put(new Character('\u247a'), new String("(7)"));
            char_map.put(new Character('\u247b'), new String("(8)"));
            char_map.put(new Character('\u247c'), new String("(9)"));
            char_map.put(new Character('\u247d'), new String("(10)"));
            char_map.put(new Character('\u247e'), new String("(11)"));
            char_map.put(new Character('\u247f'), new String("(12)"));
            char_map.put(new Character('\u2480'), new String("(13)"));
            char_map.put(new Character('\u2481'), new String("(14)"));
            char_map.put(new Character('\u2482'), new String("(15)"));
            char_map.put(new Character('\u2483'), new String("(16)"));
            char_map.put(new Character('\u2484'), new String("(17)"));
            char_map.put(new Character('\u2485'), new String("(18)"));
            char_map.put(new Character('\u2486'), new String("(19)"));
            char_map.put(new Character('\u2487'), new String("(20)"));
            char_map.put(new Character('\u2488'), new String("1."));
            char_map.put(new Character('\u2489'), new String("2."));
            char_map.put(new Character('\u248a'), new String("3."));
            char_map.put(new Character('\u248b'), new String("4."));
            char_map.put(new Character('\u248c'), new String("5."));
            char_map.put(new Character('\u248d'), new String("6."));
            char_map.put(new Character('\u248e'), new String("7."));
            char_map.put(new Character('\u248f'), new String("8."));
            char_map.put(new Character('\u2490'), new String("9."));
            char_map.put(new Character('\u2491'), new String("10."));
            char_map.put(new Character('\u2492'), new String("11."));
            char_map.put(new Character('\u2493'), new String("12."));
            char_map.put(new Character('\u2494'), new String("13."));
            char_map.put(new Character('\u2495'), new String("14."));
            char_map.put(new Character('\u2496'), new String("15."));
            char_map.put(new Character('\u2497'), new String("16."));
            char_map.put(new Character('\u2498'), new String("17."));
            char_map.put(new Character('\u2499'), new String("18."));
            char_map.put(new Character('\u249a'), new String("19."));
            char_map.put(new Character('\u249b'), new String("20."));
            char_map.put(new Character('\u249c'), new String("(a)"));
            char_map.put(new Character('\u249d'), new String("(b)"));
            char_map.put(new Character('\u249e'), new String("(c)"));
            char_map.put(new Character('\u249f'), new String("(d)"));
            char_map.put(new Character('\u24a0'), new String("(e)"));
            char_map.put(new Character('\u24a1'), new String("(f)"));
            char_map.put(new Character('\u24a2'), new String("(g)"));
            char_map.put(new Character('\u24a3'), new String("(h)"));
            char_map.put(new Character('\u24a4'), new String("(i)"));
            char_map.put(new Character('\u24a5'), new String("(j)"));
            char_map.put(new Character('\u24a6'), new String("(k)"));
            char_map.put(new Character('\u24a7'), new String("(l)"));
            char_map.put(new Character('\u24a8'), new String("(m)"));
            char_map.put(new Character('\u24a9'), new String("(n)"));
            char_map.put(new Character('\u24aa'), new String("(o)"));
            char_map.put(new Character('\u24ab'), new String("(p)"));
            char_map.put(new Character('\u24ac'), new String("(q)"));
            char_map.put(new Character('\u24ad'), new String("(r)"));
            char_map.put(new Character('\u24ae'), new String("(s)"));
            char_map.put(new Character('\u24af'), new String("(t)"));
            char_map.put(new Character('\u24b0'), new String("(u)"));
            char_map.put(new Character('\u24b1'), new String("(v)"));
            char_map.put(new Character('\u24b2'), new String("(w)"));
            char_map.put(new Character('\u24b3'), new String("(x)"));
            char_map.put(new Character('\u24b4'), new String("(y)"));
            char_map.put(new Character('\u24b5'), new String("(z)"));
            char_map.put(new Character('\u24b6'), new String("A"));
            char_map.put(new Character('\u24b7'), new String("B"));
            char_map.put(new Character('\u24b8'), new String("C"));
            char_map.put(new Character('\u24b9'), new String("D"));
            char_map.put(new Character('\u24ba'), new String("E"));
            char_map.put(new Character('\u24bb'), new String("F"));
            char_map.put(new Character('\u24bc'), new String("G"));
            char_map.put(new Character('\u24bd'), new String("H"));
            char_map.put(new Character('\u24be'), new String("I"));
            char_map.put(new Character('\u24bf'), new String("J"));
            char_map.put(new Character('\u24c0'), new String("K"));
            char_map.put(new Character('\u24c1'), new String("L"));
            char_map.put(new Character('\u24c2'), new String("M"));
            char_map.put(new Character('\u24c3'), new String("N"));
            char_map.put(new Character('\u24c4'), new String("O"));
            char_map.put(new Character('\u24c5'), new String("P"));
            char_map.put(new Character('\u24c6'), new String("Q"));
            char_map.put(new Character('\u24c7'), new String("R"));
            char_map.put(new Character('\u24c8'), new String("S"));
            char_map.put(new Character('\u24c9'), new String("T"));
            char_map.put(new Character('\u24ca'), new String("U"));
            char_map.put(new Character('\u24cb'), new String("V"));
            char_map.put(new Character('\u24cc'), new String("W"));
            char_map.put(new Character('\u24cd'), new String("X"));
            char_map.put(new Character('\u24ce'), new String("Y"));
            char_map.put(new Character('\u24cf'), new String("Z"));
            char_map.put(new Character('\u24d0'), new String("a"));
            char_map.put(new Character('\u24d1'), new String("b"));
            char_map.put(new Character('\u24d2'), new String("c"));
            char_map.put(new Character('\u24d3'), new String("d"));
            char_map.put(new Character('\u24d4'), new String("e"));
            char_map.put(new Character('\u24d5'), new String("f"));
            char_map.put(new Character('\u24d6'), new String("g"));
            char_map.put(new Character('\u24d7'), new String("h"));
            char_map.put(new Character('\u24d8'), new String("i"));
            char_map.put(new Character('\u24d9'), new String("j"));
            char_map.put(new Character('\u24da'), new String("k"));
            char_map.put(new Character('\u24db'), new String("l"));
            char_map.put(new Character('\u24dc'), new String("m"));
            char_map.put(new Character('\u24dd'), new String("n"));
            char_map.put(new Character('\u24de'), new String("o"));
            char_map.put(new Character('\u24df'), new String("p"));
            char_map.put(new Character('\u24e0'), new String("q"));
            char_map.put(new Character('\u24e1'), new String("r"));
            char_map.put(new Character('\u24e2'), new String("s"));
            char_map.put(new Character('\u24e3'), new String("t"));
            char_map.put(new Character('\u24e4'), new String("u"));
            char_map.put(new Character('\u24e5'), new String("v"));
            char_map.put(new Character('\u24e6'), new String("w"));
            char_map.put(new Character('\u24e7'), new String("x"));
            char_map.put(new Character('\u24e8'), new String("y"));
            char_map.put(new Character('\u24e9'), new String("z"));
            char_map.put(new Character('\u24ea'), new String("0"));
            char_map.put(new Character('\u24eb'), new String("(11)"));
            char_map.put(new Character('\u24ec'), new String("(12)"));
            char_map.put(new Character('\u24ed'), new String("(13)"));
            char_map.put(new Character('\u24ee'), new String("(14)"));
            char_map.put(new Character('\u24ef'), new String("(15)"));
            char_map.put(new Character('\u24f0'), new String("(16)"));
            char_map.put(new Character('\u24f1'), new String("(17)"));
            char_map.put(new Character('\u24f2'), new String("(18)"));
            char_map.put(new Character('\u24f3'), new String("(19)"));
            char_map.put(new Character('\u24f4'), new String("(20)"));
            char_map.put(new Character('\u24f5'), new String("(1)"));
            char_map.put(new Character('\u24f6'), new String("(2)"));
            char_map.put(new Character('\u24f7'), new String("(3)"));
            char_map.put(new Character('\u24f8'), new String("(4)"));
            char_map.put(new Character('\u24f9'), new String("(5)"));
            char_map.put(new Character('\u24fa'), new String("(6)"));
            char_map.put(new Character('\u24fb'), new String("(7)"));
            char_map.put(new Character('\u24fc'), new String("(8)"));
            char_map.put(new Character('\u24fd'), new String("(9)"));
            char_map.put(new Character('\u24fe'), new String("(10)"));
            char_map.put(new Character('\u24ff'), new String("(0)"));
            char_map.put(new Character('\u3000'), new String(" "));
            char_map.put(new Character('\u3001'), new String(","));
            char_map.put(new Character('\u3007'), new String("0"));
            char_map.put(new Character('\u3008'), new String("<"));
            char_map.put(new Character('\u3009'), new String(">"));
            char_map.put(new Character('\u300a'), new String("<<"));
            char_map.put(new Character('\u300b'), new String(">>"));
            char_map.put(new Character('\u301b'), new String("]"));
            char_map.put(new Character('\u301c'), new String("~"));
            char_map.put(new Character('\u3021'), new String("1"));
            char_map.put(new Character('\u3022'), new String("2"));
            char_map.put(new Character('\u3023'), new String("3"));
            char_map.put(new Character('\u3024'), new String("4"));
            char_map.put(new Character('\u3025'), new String("5"));
            char_map.put(new Character('\u3026'), new String("6"));
            char_map.put(new Character('\u3027'), new String("7"));
            char_map.put(new Character('\u3028'), new String("8"));
            char_map.put(new Character('\u3029'), new String("9"));
            char_map.put(new Character('\ufb00'), new String("ff"));
            char_map.put(new Character('\ufb01'), new String("fi"));
            char_map.put(new Character('\ufb02'), new String("fl"));
            char_map.put(new Character('\ufb03'), new String("ffi"));
            char_map.put(new Character('\ufb04'), new String("ffl"));
            char_map.put(new Character('\ufb05'), new String("st"));
            char_map.put(new Character('\ufb06'), new String("st"));
            char_map.put(new Character('\ufb29'), new String("+"));
            char_map.put(new Character('\ufe50'), new String(","));
            char_map.put(new Character('\ufe51'), new String(","));
            char_map.put(new Character('\ufe52'), new String("."));
            char_map.put(new Character('\ufe54'), new String(";"));
            char_map.put(new Character('\ufe55'), new String(":"));
            char_map.put(new Character('\ufe56'), new String("?"));
            char_map.put(new Character('\ufe57'), new String("!"));
            char_map.put(new Character('\ufe58'), new String("-"));
            char_map.put(new Character('\ufe59'), new String("("));
            char_map.put(new Character('\ufe5a'), new String(")"));
            char_map.put(new Character('\ufe5b'), new String("{"));
            char_map.put(new Character('\ufe5c'), new String("}"));
            char_map.put(new Character('\ufe5d'), new String("("));
            char_map.put(new Character('\ufe5e'), new String(")"));
            char_map.put(new Character('\ufe5f'), new String("#"));
            char_map.put(new Character('\ufe60'), new String("&"));
            char_map.put(new Character('\ufe61'), new String("*"));
            char_map.put(new Character('\ufe62'), new String("+"));
            char_map.put(new Character('\ufe63'), new String("-"));
            char_map.put(new Character('\ufe64'), new String("<"));
            char_map.put(new Character('\ufe65'), new String(">"));
            char_map.put(new Character('\ufe66'), new String("="));
            char_map.put(new Character('\ufe69'), new String("$"));
            char_map.put(new Character('\ufe6a'), new String("%"));
            char_map.put(new Character('\ufe6b'), new String("@"));
            char_map.put(new Character('\uff01'), new String("!"));
            char_map.put(new Character('\uff03'), new String("#"));
            char_map.put(new Character('\uff04'), new String("$"));
            char_map.put(new Character('\uff05'), new String("%"));
            char_map.put(new Character('\uff06'), new String("&"));
            char_map.put(new Character('\uff07'), new String("'"));
            char_map.put(new Character('\uff08'), new String("("));
            char_map.put(new Character('\uff09'), new String(")"));
            char_map.put(new Character('\uff0a'), new String("*"));
            char_map.put(new Character('\uff0b'), new String("+"));
            char_map.put(new Character('\uff0c'), new String(","));
            char_map.put(new Character('\uff0d'), new String("-"));
            char_map.put(new Character('\uff0e'), new String("."));
            char_map.put(new Character('\uff0f'), new String("/"));
            char_map.put(new Character('\uff10'), new String("0"));
            char_map.put(new Character('\uff11'), new String("1"));
            char_map.put(new Character('\uff12'), new String("2"));
            char_map.put(new Character('\uff13'), new String("3"));
            char_map.put(new Character('\uff14'), new String("4"));
            char_map.put(new Character('\uff15'), new String("5"));
            char_map.put(new Character('\uff16'), new String("6"));
            char_map.put(new Character('\uff17'), new String("7"));
            char_map.put(new Character('\uff18'), new String("8"));
            char_map.put(new Character('\uff19'), new String("9"));
            char_map.put(new Character('\uff1a'), new String(":"));
            char_map.put(new Character('\uff1b'), new String(";"));
            char_map.put(new Character('\uff1c'), new String("<"));
            char_map.put(new Character('\uff1d'), new String("="));
            char_map.put(new Character('\uff1e'), new String(">"));
            char_map.put(new Character('\uff1f'), new String("?"));
            char_map.put(new Character('\uff20'), new String("@"));
            char_map.put(new Character('\uff21'), new String("A"));
            char_map.put(new Character('\uff22'), new String("B"));
            char_map.put(new Character('\uff23'), new String("C"));
            char_map.put(new Character('\uff24'), new String("D"));
            char_map.put(new Character('\uff25'), new String("E"));
            char_map.put(new Character('\uff26'), new String("F"));
            char_map.put(new Character('\uff27'), new String("G"));
            char_map.put(new Character('\uff28'), new String("H"));
            char_map.put(new Character('\uff29'), new String("I"));
            char_map.put(new Character('\uff2a'), new String("J"));
            char_map.put(new Character('\uff2b'), new String("K"));
            char_map.put(new Character('\uff2c'), new String("L"));
            char_map.put(new Character('\uff2d'), new String("M"));
            char_map.put(new Character('\uff2e'), new String("N"));
            char_map.put(new Character('\uff2f'), new String("O"));
            char_map.put(new Character('\uff30'), new String("P"));
            char_map.put(new Character('\uff31'), new String("Q"));
            char_map.put(new Character('\uff32'), new String("R"));
            char_map.put(new Character('\uff33'), new String("S"));
            char_map.put(new Character('\uff34'), new String("T"));
            char_map.put(new Character('\uff35'), new String("U"));
            char_map.put(new Character('\uff36'), new String("V"));
            char_map.put(new Character('\uff37'), new String("W"));
            char_map.put(new Character('\uff38'), new String("X"));
            char_map.put(new Character('\uff39'), new String("Y"));
            char_map.put(new Character('\uff3a'), new String("Z"));
            char_map.put(new Character('\uff3b'), new String("["));
            char_map.put(new Character('\uff3d'), new String("]"));
            char_map.put(new Character('\uff3e'), new String("^"));
            char_map.put(new Character('\uff3f'), new String("_"));
            char_map.put(new Character('\uff40'), new String("`"));
            char_map.put(new Character('\uff41'), new String("a"));
            char_map.put(new Character('\uff42'), new String("b"));
            char_map.put(new Character('\uff43'), new String("c"));
            char_map.put(new Character('\uff44'), new String("d"));
            char_map.put(new Character('\uff45'), new String("e"));
            char_map.put(new Character('\uff46'), new String("f"));
            char_map.put(new Character('\uff47'), new String("g"));
            char_map.put(new Character('\uff48'), new String("h"));
            char_map.put(new Character('\uff49'), new String("i"));
            char_map.put(new Character('\uff4a'), new String("j"));
            char_map.put(new Character('\uff4b'), new String("k"));
            char_map.put(new Character('\uff4c'), new String("l"));
            char_map.put(new Character('\uff4d'), new String("m"));
            char_map.put(new Character('\uff4e'), new String("n"));
            char_map.put(new Character('\uff4f'), new String("o"));
            char_map.put(new Character('\uff50'), new String("p"));
            char_map.put(new Character('\uff51'), new String("q"));
            char_map.put(new Character('\uff52'), new String("r"));
            char_map.put(new Character('\uff53'), new String("s"));
            char_map.put(new Character('\uff54'), new String("t"));
            char_map.put(new Character('\uff55'), new String("u"));
            char_map.put(new Character('\uff56'), new String("v"));
            char_map.put(new Character('\uff57'), new String("w"));
            char_map.put(new Character('\uff58'), new String("x"));
            char_map.put(new Character('\uff59'), new String("y"));
            char_map.put(new Character('\uff5a'), new String("z"));
            char_map.put(new Character('\uff5b'), new String("{"));
            char_map.put(new Character('\uff5c'), new String("|"));
            char_map.put(new Character('\uff5d'), new String("}"));
            char_map.put(new Character('\uff5e'), new String("~"));
            char_map.put(new Character('\uff5f'), new String("("));
            char_map.put(new Character('\uff60'), new String(")"));
            char_map.put(new Character('\uff64'), new String(","));
            char_map.put(new Character('\uffe9'), new String("<-"));
            char_map.put(new Character('\uffeb'), new String("->"));

            // 08/11/2011
            char_map.put(new Character('\u2000'), new String(" "));
            char_map.put(new Character('\u2001'), new String(" "));
            char_map.put(new Character('\u2004'), new String(" "));
            char_map.put(new Character('\u2005'), new String(" "));
            char_map.put(new Character('\u2006'), new String(" "));
            char_map.put(new Character('\u2007'), new String(" "));
            char_map.put(new Character('\u2008'), new String(" "));
            char_map.put(new Character('\u200A'), new String(" "));
            char_map.put(new Character('\u200B'), new String(" "));
            char_map.put(new Character('\u2215'), new String("/"));
            char_map.put(new Character('\u207b'), new String("-"));
            char_map.put(new Character('\u208b'), new String("-"));
            char_map.put(new Character('\u2212'), new String("-"));
            char_map.put(new Character('\u2264'), new String("<="));
            char_map.put(new Character('\u2265'), new String(">="));
            char_map.put(new Character('\uc2a0'), new String(" "));
            char_map.put(new Character('\ufeff'), new String(" "));

            // From MetaMorphosys

            char_map.put(new Character('\u200E'), new String(""));
            char_map.put(new Character('\u2020'), new String(""));
            char_map.put(new Character('\u2217'), new String("*"));
            char_map.put(new Character('\u0092'), new String(""));

            // 05/30/2012

            char_map.put(new Character('\u00f0'), new String("d"));  // Decimal=240 (Latin Small Letter Eth)
            char_map.put(new Character('\u0138'), new String("K"));  // Decimal=312 (Latin Small Letter KRA)
            char_map.put(new Character('\u0150'), new String("O"));  // Decimal=330 (Latin Capital Letter O With Double Acute)
            char_map.put(new Character('\u018d'), new String("d"));  // Decimal=397 (Latin Small Letter Turned Delta)

            char_map.put(new Character('\u018f'), new String("e"));  // Decimal=399 (Latin Capital Letter Schwa)
            char_map.put(new Character('\u0189'), new String("D"));  // Decimal=425 (Latin Capital Letter African D)
            char_map.put(new Character('\u0190'), new String("E"));  // Decimal=426 (Latin Capital Letter Open E)
            char_map.put(new Character('\u01b7'), new String("3"));  // Decimal=439 (Latin Capital Letter Ezh)
            char_map.put(new Character('\u01b8'), new String("E"));  // Decimal=440 (Latin Capital Letter Ezh Reversed)
            char_map.put(new Character('\u01b9'), new String("e"));  // Decimal=441 (Latin Small Letter Ezh Reversed)
            char_map.put(new Character('\u01ba'), new String("e"));  // Decimal=442 (Latin Small Letter Ezh With Tail)
            char_map.put(new Character('\u01be'), new String("t"));  // Decimal=446 (Latin Letter Inverted Glottal Stop With Stroke)
            char_map.put(new Character('\u01bf'), new String("p"));  // Decimal=447 (Latin Letter Wynn)
            char_map.put(new Character('\u01c1'), new String("||")); // Decimal=449 (Latin Letter Lateral Click)
            char_map.put(new Character('\u01ee'), new String("3"));  // Decimal=494 (Latin Capital Letter Ezh With Caron)
            char_map.put(new Character('\u01ef'), new String("3"));  // Decimal=495 (Latin Small Letter Ezh With Caron)

            // From MetamorphoSys 10/10/2014

            char_map.put(new Character('\u0323'), new String(""));
            char_map.put(new Character('\u0410'), new String(""));
            char_map.put(new Character('\u0411'), new String(""));
            char_map.put(new Character('\u0412'), new String(""));
            char_map.put(new Character('\u0413'), new String(""));
            char_map.put(new Character('\u0414'), new String(""));
            char_map.put(new Character('\u0415'), new String(""));
            char_map.put(new Character('\u0416'), new String(""));
            char_map.put(new Character('\u0417'), new String(""));
            char_map.put(new Character('\u0418'), new String(""));
            char_map.put(new Character('\u0419'), new String(""));
            char_map.put(new Character('\u041a'), new String(""));
            char_map.put(new Character('\u041b'), new String(""));
            char_map.put(new Character('\u041c'), new String(""));
            char_map.put(new Character('\u041d'), new String(""));
            char_map.put(new Character('\u041e'), new String(""));
            char_map.put(new Character('\u041f'), new String(""));
            char_map.put(new Character('\u0420'), new String(""));
            char_map.put(new Character('\u0421'), new String(""));
            char_map.put(new Character('\u0422'), new String(""));
            char_map.put(new Character('\u0423'), new String(""));
            char_map.put(new Character('\u0424'), new String(""));
            char_map.put(new Character('\u0425'), new String(""));
            char_map.put(new Character('\u0426'), new String(""));
            char_map.put(new Character('\u0427'), new String(""));
            char_map.put(new Character('\u0428'), new String(""));
            char_map.put(new Character('\u0429'), new String(""));
            char_map.put(new Character('\u042a'), new String(""));
            char_map.put(new Character('\u042b'), new String(""));
            char_map.put(new Character('\u042c'), new String(""));
            char_map.put(new Character('\u042d'), new String(""));
            char_map.put(new Character('\u042e'), new String(""));
            char_map.put(new Character('\u042f'), new String(""));
            char_map.put(new Character('\u0430'), new String(""));
            char_map.put(new Character('\u0431'), new String(""));
            char_map.put(new Character('\u0432'), new String(""));
            char_map.put(new Character('\u0433'), new String(""));
            char_map.put(new Character('\u0434'), new String(""));
            char_map.put(new Character('\u0435'), new String(""));
            char_map.put(new Character('\u0436'), new String(""));
            char_map.put(new Character('\u0437'), new String(""));
            char_map.put(new Character('\u0438'), new String(""));
            char_map.put(new Character('\u0439'), new String(""));
            char_map.put(new Character('\u043a'), new String(""));
            char_map.put(new Character('\u043b'), new String(""));
            char_map.put(new Character('\u043c'), new String(""));
            char_map.put(new Character('\u043d'), new String(""));
            char_map.put(new Character('\u043e'), new String(""));
            char_map.put(new Character('\u043f'), new String(""));
            char_map.put(new Character('\u0440'), new String(""));
            char_map.put(new Character('\u0441'), new String(""));
            char_map.put(new Character('\u0442'), new String(""));
            char_map.put(new Character('\u0443'), new String(""));
            char_map.put(new Character('\u0444'), new String(""));
            char_map.put(new Character('\u0445'), new String(""));
            char_map.put(new Character('\u0446'), new String(""));
            char_map.put(new Character('\u0447'), new String(""));
            char_map.put(new Character('\u0448'), new String(""));
            char_map.put(new Character('\u0449'), new String(""));
            char_map.put(new Character('\u044a'), new String(""));
            char_map.put(new Character('\u044b'), new String(""));
            char_map.put(new Character('\u044c'), new String(""));
            char_map.put(new Character('\u044d'), new String(""));
            char_map.put(new Character('\u044e'), new String(""));
            char_map.put(new Character('\u044f'), new String(""));
            char_map.put(new Character('\u0451'), new String(""));
            char_map.put(new Character('\u200b'), new String(""));
            char_map.put(new Character('\u200e'), new String(""));
            char_map.put(new Character('\u2022'), new String(""));
            char_map.put(new Character('\u2261'), new String(""));
            char_map.put(new Character('\u8166'), new String(""));
            char_map.put(new Character('\u982d'), new String(""));
            char_map.put(new Character('\ub1cc'), new String(""));
            char_map.put(new Character('\ub450'), new String(""));
            char_map.put(new Character('\uf030'), new String(""));

            //Special case ʻ, ≈, \, image of Unicode Character 'FUNCTION APPLICATION' (U+2061)
            char_map.put(new Character('\u02bb'), new String(""));//ʻ
            char_map.put(new Character('\u034c'), new String(""));//≈
            char_map.put(new Character('\u2248'), new String(""));//≈
            char_map.put(new Character('\u2061'), new String(""));
            char_map.put(new Character('\u2060'), new String(""));//WORD JOINER
            char_map.put(new Character('\u1fd6'), new String(""));//ῖ
            char_map.put(new Character('\u2191'), new String(""));//↑
            char_map.put(new Character('\u2193'), new String(""));//↓
            char_map.put(new Character('\u02da'), new String(""));//˚
            char_map.put(new Character('\u030a'), new String(""));//̊
            //char_map.put(new Character('\n'), new String(""));//salto linea
            char_map.put(new Character('\u27f6'), new String(""));//⟶
        }

        //Replaces special characters with look-like ASCII chars
        public String replaceLooklike(String input) throws IOException
        {
//            System.out.println("INPUT: " + input);
            StringBuffer tempBuf = new StringBuffer();
            int len = input.length();
            for(int i = 0; i < len; i++)
            {

                if(input.charAt(i) != ' ')
                {
                    String rep_char = char_map.get( new Character(input.charAt(i)) );
                    //System.out.println("INPUT("+ input.charAt(i)+"): " + input.charAt(i) + " REPLACE: " + rep_char);
                    //System.out.println( common.getUnicode(input.charAt(i)) );
                    if (rep_char == null){//Si entra aquí convertiremos el caracter a "". Puede ser caracter asiatico o
                                          //algun otro caracter que no esté incluido arriba
                        rep_char = "";
                    }
                    if(rep_char != null )
                        tempBuf.append(rep_char);

                        // Handle various double-quotes

                    else if((input.charAt(i) == '\u0022') ||
                            (input.charAt(i) == '\u00ab') || (input.charAt(i) == '\u00bb') ||
                            (input.charAt(i) == '\u201c') || (input.charAt(i) == '\u201e') ||
                            (input.charAt(i) == '\u201f') || (input.charAt(i) == '\u2033') ||
                            (input.charAt(i) == '\u2036') || (input.charAt(i) == '\u3003') ||
                            (input.charAt(i) == '\u301d') || (input.charAt(i) == '\u301e') ||
                            (input.charAt(i) == '\uff02') || (input.charAt(i) == '\u201d') ||
                            (input.charAt(i) == '\u00ab') || (input.charAt(i) == '\u00bb') ||
                            (input.charAt(i) == '\u301f'))
                        tempBuf.append('"');

                    else if(input.charAt(i) != '\u00bf')
                        tempBuf.append(input.charAt(i));
                } // fi

                else
                    tempBuf.append(input.charAt(i));
            } // for

            return tempBuf.toString();

        } // ReplaceLooklike
}// class ReplaceUTF8
