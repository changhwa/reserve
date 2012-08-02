function split(str1, str2) {
	var oriStr = new String(str1);
	var replaceStr=new String(str2) ;
	var arr1 = new Array();
	while (oriStr.indexOf(replaceStr) != -1) {
		arr1[arr1.length] = oriStr.substring(0, oriStr.indexOf(replaceStr));
		oriStr = oriStr.substring(oriStr.indexOf(replaceStr) + replaceStr.length,
				oriStr.length);
	}
	arr1[arr1.length] = oriStr;
	return arr1;

}

function removeArray(array,num){
	var temp = new Array();

	for(var i=0;i<array.length;i++){
		if(num==array[i]){
			//array.splice(i,1);
		}else{
			temp.push(array[i]);
		}
	}

	return temp;
}