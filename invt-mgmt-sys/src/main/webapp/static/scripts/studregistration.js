/**
 * @author Manoj Patel
 */

$(document).ready(function() {
	// Smart Wizard
	schoolmanagementfunctions.formvalidator();
	$('#wizard').smartWizard();

	$('.finish').click(function(e) {
		e.preventDefault();
		submit($(this).parents('div.form_wizard').find('form'));
	}); 
});

$(document).ready(function() {
	$('#birthday').daterangepicker({
		singleDatePicker : true,
		calender_style : "picker_4"
	}, function(start, end, label) {
		console.log(start.toISOString(), end.toISOString(), label);
	});
});