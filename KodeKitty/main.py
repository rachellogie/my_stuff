#!/usr/bin/env python
#
# Copyright 2007 Google Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
import webapp2

MAIN_PAGE_HTML = """\
<html>

<head>
	<title> Meatball </title>
	<link type="text/css" rel="stylesheet" href="mypage_stylesheet.css"/>
	<link href='http://fonts.googleapis.com/css?family=Abril+Fatface' rel='stylesheet' type='text/css'>
</head>

<body>
	<div class="left">
		<h1>Hi,</h1>
		<h1>This is my cat Meatball.</h1>
		<p>I love cats, especially fat ones.</p>
	</div>
	<div class="right">
		<img src="meatball.jpg">
	</div>




</body>
</html>


"""

class MainHandler(webapp2.RequestHandler):
    def get(self):
        self.response.write(MAIN_PAGE_HTML)

app = webapp2.WSGIApplication([
    ('/', MainHandler)
], debug=True)
