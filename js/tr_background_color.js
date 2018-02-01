$(function(){
 tr_default("#tbl1");
 tr_default("#tbl2");
 $("#tbl1 tr").click(function(){
  tr_default("#tbl1");
  tr_click($(this));
 });
 $("#tbl2 tr").click(function(){
  tr_default("#tbl2");
  tr_click($(this));
 });
});

function tr_default(tblID){
 var vTR = tblID + " tr";
 $(vTR).css("background-color","#ffffff");
 $(vTR).mouseover(function(){
  $(this).css("background-color","#CCFFCC") .css("cursor","pointer")
 });
 $(vTR).mouseout(function(){
  $(this).css("background-color","#ffffff") .css("cursor","normal")
 });
}

function tr_click(trID){
 trID.css("background-color","#e49e61");
 trID.mouseover(function(){
  $(this).css("background-color","#CCFFCC") .css("cursor","pointer")
 });
 trID.mouseout(function(){
  $(this).css("background-color","#e49e61") .css("cursor","normal")
 });
}