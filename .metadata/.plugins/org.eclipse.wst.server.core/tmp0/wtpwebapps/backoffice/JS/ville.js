function gov(x) {
	var gover = document.getElementById('region').value;
	var arr=[];
	switch (gover){
	case "Ariana" : var arr=["Ariana Ville","La Soukra","Ettadhamen","Raoued","Mnihla","Kalaat el-Andalous","Sidi Thabet"];break;
	case "Beja" : var arr=["Beja Nord","Nefza","Medjez el-Bab","Beja Sud","Testour","Teboursouk","Amdoun","Goubellat","Thibar"];break;
	case "Ben Arous" : var arr=["El Mourouj","Fouchana","Mornag","Mohamedia","Rades","Medina Jedida","Hammam Lif","Ben Arous","Ezzahra","Bou Mhel el-Bassatine","Hammam Chott","Megrine"];break;
	case "Bizerte" : var arr=["Bizerte Nord","Menzel Bourguiba","Ras Jebel","Mateur","Bizerte Sud","Sejnane","Menzel Jemil","Joumine","Ghezala","El Alia","Zarzouna","Tinja","Ghar El Melh","Utique"];break;
	case "Gabes" : var arr=["El Hamma","Gabes Sud","Mareth","Gabes Medina","Gabes Ouest","Metouia","Ghannouch","Nouvelle Matmata","Menzel El Habib","Matmata"];break;
	case "Gafsa" : var arr=["Gafsa Sud","Metlaoui","Sened","El Ksar","Moulares","Redeyef","El Guettar","Belkhir","Mdhilla","Gafsa Nord","Sidi Aich"];break;
	case "Jendouba" : var arr=["Jendouba Sud","Ghardimaou","Fernana","Tabarka","Jendouba Nord","Balta-Bou Aouane","Ain Draham","Bou Salem","Oued Meliz"];break;
	case "Kairouan" : var arr=["Kairouan Nord","Kairouan Sud","Bou Hajla","Sbikha","Haffouz","Nasrallah","Oueslatia","Hajeb El Ayoun","Chebika","El Alaa","Echrarda"];break;
	case "El Kasserine" : var arr=["Sbeïtla","Kasserine Nord","Feriana","Sbiba","Foussana","Thala","Majel Bel Abbès","Kasserine Sud","Ezzouhour","El Ayoun","Hassi El Ferid","Jedelienne","Haidra"];break;
	case "Kebili" : var arr=["Kebili Sud","Kebili Nord","Souk Lahad","Douz Nord","Douz Sud","Faouar"];break;
	case "Le Kef" : var arr=["Kef Est","Dahmani","Tajerouine","Kef Ouest","Nebeur","Sers","Sakiet Sidi Youssef","El Ksour","Kalaat Senan","Jerissa","Kalaat Khasba"];break;
	case "Mahdia" : var arr=["Mahdia","Ksour Essef","Essouassi","El Jem","Sidi Alouane","Bou Merdes","Chorbane","Chebba","Ouled Chamekh","Mellouleche","Hebira"];break;
	case "La Manouba" : var arr=["Douar Hicher","Oued Ellil","La Manouba","Tebourba","Djedeida","Mornaguia","El Batan","Borj El Amri"];break;
	case "Medenine" : var arr=["Zarzis","Ben Gardane","Houmt Souk","Midoun","Medenine Nord","Medenine Sud","Beni Khedache","Ajim","Sidi Makhlouf"];break;
	case "Monastir" : var arr=["Monastir","Moknine","Jemmal","Ksar Hellal","Teboulba","Ksibet el-Mediouni","Bembla","Zeramdine","Sayada-Lamta-Bou Hajar","Sahline","Ouerdanine","Bekalta","Beni Hassen"];break;
	case "Nabeul" : var arr=["Hammamet","Korba","Nabeul","Menzel Temime","Grombalia","Kelibia","Soliman","Dar Chaabane El Fehri","El Haouaria","Beni Khiar","Beni Khalled","Menzel Bouzelfa","Bou Argoub","El Mida","Takelsa","Hammam Ghezeze"];break;
	case "Sfax" : var arr=["Sakiet Eddaier","Sakiet Ezzit","Sfax Ville","Sfax Ouest","Sfax Sud","Bir Ali Ben Khalifa","Thyna","Jebiniana","El Hencha","Agareb","Menzel Chaker","Mahres","Skhira","El Amra","Graiba","Kerkennah"];break;
	case "Sidi Bouzid" : var arr=["Sidi Bouzid Ouest","Regueb","Sidi Bouzid Est","Jilma","Bir El Hafey","Sidi Ali Ben Aoun","Menzel Bouzaiane","Mezzouna","Meknassy","Ouled Haffouz","Souk Jedid","Cebbala Ouled Asker"];break;
	case "Siliana" : var arr=["Makthar","Rouhia","Siliana Sud","Siliana Nord","El Krib","Bou Arada","Gaafour","Kesra","Sidi Bou Rouis","Bargou","El Aroussa"];break;
	case "Sousse" : var arr=["M'saken","Sousse Riadh","Sousse Jawhara","Kalaa Kebira","Sousse Sidi Abdelhamid","Enfida","Hammam Sousse","Sousse Medina","Kalaa Seghira","Akouda","Bouficha","Sidi Bou Ali","Kondar","Sidi El Hani","Hergla"];break;
	case "Tataouine" : var arr=["Tataouine Nord","Tataouine Sud","Ghomrassen","Smâr","Remada","Bir Lahmar","Dehiba"];break;
	case "Tozeur" : var arr=["Tozeur","Degache","Nefta","Tameghza","Hazoua"];break;
	case "Tunis" : var arr=["Hrairia","El Kabaria","Sidi Hassine","La Marsa","Le Bardo","El Omrane superieur","Le Kram","El Menzah","El Omrane","Ezzouhour","Bab El Bhar","Cite El Khadra","Sejoumi","El Ouardia","Bab Souika","Sidi El Bechir","La Goulette","Medina","Djebel Jelloud","Ettahrir","Carthage"];break;
	case "Zaghouan" : var arr=["El Fahs","Zaghouan","Nadhour","Bir Mcherga","Zriba","Saouaf"];break;
	}
	var string="";
	if (x==0) string = '<option disable value="">-- Choisir une delegation --</option>';
	if (x==1) string = '<option value="">'+"N'importe</option>";
	for (i = 0; i < arr.length; i++) {
		if (document.getElementById("delegationn").value == arr[i]) string = string + "<option value='" + arr[i] + "' selected>" + arr[i]+ "</option>";
		else string = string + "<option value='" + arr[i] + "'>" + arr[i]+ "</option>";
	}
	document.getElementById("delegation").innerHTML = string;
}
