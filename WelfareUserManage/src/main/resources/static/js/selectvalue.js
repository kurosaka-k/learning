/**
 * 
 */
let select_region;
window.addEventListener('DOMContentLoaded',function(){
		select_region = document.querySelector("select[name=region]");
		console.log(select_region.value);	
	select_region.addEventListener('change',function(){
		console.log(select_region.value);
	});
});
function selectregion(){
		select_region = document.querySelector("select[name=region]");
		console.log(select_region.value);
		return select_region.value;
	}