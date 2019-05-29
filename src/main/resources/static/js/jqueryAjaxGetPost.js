$( document ).ready(function() {
	
	var listTasks = [];

	/**
	 * Using JQuery for hiding some elements in view when bootstrap app
	 */
	// Hide task table when starting
	// we just show it if having any adding-task
	$('#taskTable').hide();
	$('#postTasksBtn').hide();

	// Task-Form submit
    $("#taskForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		
		// get data from submit form
		var formTask = {

    			startTime : $("#startTime").val(),
    			endTime : $("#endTime").val()
    	}
		
		// store task
		listTasks.push(formTask);

		// re-render task table by append new task to table
		console.log(formTask);
		var taskRow = '<tr>' +

							'<td>' + formTask.startTime + '</td>' +
							'<td>' + formTask.endTime + '</td>' +
					        '<td class="text-center">' +
					        	 +
					        	'<a>' +
					  				'<span class="glyphicon glyphicon-remove"></span>' +
								'</a>' +
					        '</td>' +
						  '</tr>';

		$('#taskTable tbody').append(taskRow);

		// just how task table and POST button
		$('#taskTable').show();
		$('#postTasksBtn').show();

		// Reset FormData after Posting
    	resetData();
	});

	// Do DELETE a Task via JQUERY AJAX
	$(document).on("click","a",function() {
		var taskId = $(this).parent().find('input').val();
		$(this).closest("tr").remove()
	});

	// POST REQUEST
	$('#postTasksBtn').click(function(){
		ajaxPost();
	});


	// DO POST
    function ajaxPost(){
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			accept: 'text/plain',
			url :  "api/logtime/save",
			data: JSON.stringify(listTasks),
			dataType: 'text',
			success : function(data) {
				console.log(data);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }


	/**
	 * format string to display date in view
	 */
	function timeFormat(date){
		if(date instanceof Date){
			var isoDate = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
			var time = date.toLocaleString('en-US', { hour: 'numeric',minute:'numeric', hour12: true });
			return isoDate + ' @ ' + time;
		}else{
			return "";
		}
	}

    function resetData(){
    	$("#taskName").val("");
    	$("#startTime").val("");
    	$("#endTime").val("");
    }
})