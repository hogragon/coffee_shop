/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var sendRequest = function (url, verb, data, successCallback, errorCallback, options) 
//{
//    var requestOptions = options || {};
//    requestOptions.type = verb;
//    requestOptions.success = successCallback;
//    requestOptions.processData = false;
//    requestOptions.error = errorCallback;    
//    requestOptions.dataType  = "text";    
//    requestOptions.headers  = { "content-Type" : "application/json" }; 
//
//    var dataToSend = JSON.parse(data);
////        dataToSend['session_id'] = this.session;
//    dataToSend = JSON.stringify(dataToSend);
//
//    if (!url || !verb) 
//    {
//        errorCallback(401, "URL and HTTP verb required");
//    }
//    if (dataToSend) 
//    {   
//        requestOptions.data = dataToSend;
//    }
//
//    $.ajax(url, requestOptions);
//};
//
//var sendFormRequest = function (url, verb, data, successCallback, errorCallback, options) 
//{
//    var requestOptions = options || {};
//    requestOptions.type = "POST";
//    requestOptions.success = successCallback;
//    requestOptions.error = errorCallback;    
//    requestOptions.data = data;
//
//    if (!url || !verb) 
//    {
//        errorCallback(401, "URL and HTTP verb required");
//    }
//    
//
//    $.ajax(url, requestOptions);
//};

var onCompleteGetData = function(data){
    console.log(data);
    //var gameData = JSON.parse(data);
};
var onError =function(data){
    console.log(data);
};

function addPerson(){
    
    $.post("/person/create",$("#formAddPerson").serialize())
            .done(onCompleteGetData)
            .error(onError);
    return false;
}

function updatePerson(){
    
    $.post("/person/private/update",$("#formUpdatePerson").serialize())
            .done(onCompleteGetData)
            .error(onError);
    return false;
}

function removeProduct(productId){
    $("#productId").val(productId);
    $("#formRemoveProduct").submit();
}

function cancelOrder(){
    $('#formPlaceOrder').attr('action', '/orderflow/cancel');
    $("#formPlaceOrder").submit();
}

//$("document").ready(function(){
//
//});



