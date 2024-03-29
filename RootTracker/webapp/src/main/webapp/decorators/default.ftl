[#ftl]
<!DOCTYPE html>

<html lang="en">
<head>
    <title>[#if title != '']${title}[#else]Welcome[/#if] | ${rc.getMessage("webapp.name")}</title>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="${base}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="${base}/styles/deliciouslyblue/theme.css" title="default" />
    <link rel="alternate stylesheet" type="text/css" href="${base}/styles/deliciouslygreen/theme.css" title="green" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/prototype/1.6.0.3/prototype.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/scriptaculous/1.8.1/scriptaculous.js"></script>
    <script type="text/javascript" src="${base}/scripts/stylesheetswitcher.js"></script>
    <script type="text/javascript" src="${base}/scripts/rsh.compressed.js"></script>
    <script type="text/javascript" src="${base}/scripts/global.js"></script>
	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
	<script src="${base}/scripts/js/jquery.iframe-transport.js"></script>
	<!-- The basic File Upload plugin -->
	<script src="${base}/scripts/js/jquery.fileupload.js"></script>
	<!-- The File Upload image processing plugin -->
	<script src="${base}/scripts/js/jquery.fileupload-ip.js"></script>
	<!-- The File Upload user interface plugin -->
	<script src="${base}/scripts/js/jquery.fileupload-ui.js"></script>
	<!-- The localization script -->
	<script src="${base}/scripts/js/locale.js"></script>
	<!-- The main application script -->
	<script src="${base}/scripts/js/main.js"></script>
	<!-- The XDomainRequest Transport is included for cross-domain file deletion for IE8+ -->
	<!--[if gte IE 8]><script src="${base}js/cors/jquery.xdr-transport.js"></script><![endif]-->
    ${head}
</head>
<body>
<div id="ajaxLoading" style="display: none; position: absolute; top: 0; right: 0; background: red; padding: 5px 10px; color: white">Loading...</div>
<a name="top"></a>
<div id="page">
    <div id="header" class="clearfix">
        <h1 style="cursor: pointer" onclick="location.href='${base}/'">${rc.getMessage("webapp.name")}</h1>
        <div id="branding">
            <a href="http://appfuse.org" title="AppFuse - eliminating project startup time">
                <img src="${base}/images/powered-by-appfuse.gif" width="203" height="75" alt="AppFuse"/></a>
        </div>

        <p>${rc.getMessage("webapp.tagline")}</p>
    </div>

    <div id="content">

        <div id="main">
            <h1>${title}</h1>
            <div id="body">
                [#include "/messages.ftl"/]
                ${body}

                <div id="underground">
                    [#if page.getProperty("page.underground")?exists]
                    ${page.getProperty("page.underground")}
                    [/#if]
                </div>
            </div>
        </div>

        <div id="sub">
            <h3>Resources</h3>

            <p>The following is a list of resources that will make <a href="http://springframework.org">Spring</a> infinitely easier to use.</p>

            <ul class="glassList">
                <li><a href="${base}/" title="Home"><span>Home</span></a></li>
              <li><a href="${base}/itemForm" title="Upload"><span>New Item</span></a></li>
                    <li><a href="${base}/categoryForm" title="Upload"><span>New Category</span></a></li>
                    <li><a href="${base}/storeForm" title="Upload"><span>New Store</span></a></li>	
            </ul>

            <img src="${base}/images/image.gif" alt="Click to Change Theme" width="150" height="112" class="right" style="margin: 10px 0 20px 0"
                 onclick="StyleSheetSwitcher.setActive((StyleSheetSwitcher.getActive() == 'default') ? 'green' : 'default')"/>
        </div>

        <div id="nav">
            <div class="wrapper">
                <h2 class="accessibility">Navigation</h2>
                <ul class="clearfix">
                    <li><a href="${base}/" title="Home"><span>Home</span></a></li>
                    <li><a href="${base}/items" title="Upload"><span>Item</span></a></li>
                    <li><a href="${base}/categories" title="Upload"><span>Category</span></a></li>
                    <li><a href="${base}/stores" title="Upload"><span>Store</span></a></li>	
                </ul>
            </div>
        </div><!-- end nav -->

    </div><!-- end content -->

    <div id="footer">
        <p>
            <a href="http://www.oswd.org/design/preview/id/2634">Deliciously Blue</a> from <a href="http://www.oswd.org/">OSWD</a> |
            Design by <a href="http://www.oswd.org/user/profile/id/8377">super j man</a>
        </p>
    </div>
</div>
</body>
</html>