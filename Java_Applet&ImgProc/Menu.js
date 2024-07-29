window.loadDropdown = function() {
  // Fetch data from SharePoint list
  $.ajax({
    url: "https://y3mbk.sharepoint.com/sites/SharePointCRUD/_api/web/lists/getbytitle('ApplicationMenuItems')",
    method: "GET",
    headers: {
      "Accept": "application/json; odata=verbose"
    },
    success: function(data) {
      // Parse data and populate dropdown
      $.each(data.d.results, function(index, item) {
        $("#myDropdown").append("<a href='" + item.Url + "'>" + item.Title + "</a>");
      });
    },
    error: function(error) {
      console.log("Error fetching data: " + error);
    }
  });

  // Show/hide dropdown content on button click
  $(".dropbtn").click(function() {
    $("#myDropdown").toggleClass("show");
  });

  // Close the dropdown if the user clicks outside of it
  $(window).click(function(event) {
    if (!event.target.matches('.dropbtn')) {
      var dropdowns = $(".dropdown-content");
      dropdowns.removeClass('show');
    }
  });

  // Load URL when dropdown option is clicked
  $("#myDropdown").on("click", "a", function(event) {
    event.preventDefault(); // Prevent default link behavior
    var url = $(this).attr("href");
    window.location.href = url; // Load URL
  });
};