$(document).ready(function() {
  // SharePoint list URL
  var listUrl = "https://y3mbk.sharepoint.com/sites/SharePointCRUD/_api/web/lists/getbytitle('ApplicationMenuItems')/items";

  // Fetch data from SharePoint list
  $.ajax({
    url: listUrl,
    method: "GET",
    headers: {
      "Accept": "application/json; odata=verbose"
    },
    success: function(data) {
      // Loop through list items and create hyperlinks
      $.each(data.d.results, function(index, item) {
        // Append hyperlink to a container element
        $("#linksContainer").append("<a href='" + item.Url.Url + "'>" + item.Title + "</a><br>");
      });
    },
    error: function(error) {
      console.log("Error fetching data: " + error);
    }
  });
});
