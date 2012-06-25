# PhoneListener Extension
This extension enables a WebWorks app to listen for call events (“initiated” or “incoming” calls)  connected & disconnected can be implemented later.  The Phonecall object is passed back to the WebWorks app, where properties could be read off of the object:
* phoneno – string containing the phone number of the initiated/incoming call
* isoutgoing – bool value, true if call is outgoing – false if not outgoing
* displayphoneno – string value returning the “friendly version” of a phone number applicable if phone number is attached to contact in address book
* phoneevent – string value returning the type of event that was triggered (“callInitated” or “callIncoming”);

**Author:** [Maurice White](https://github.com/mdwhite76) 

## Tested On

* BlackBerry Bold 9900 v7.1.0.251


**Requires BlackBerry WebWorks SDK for Smartphones v2.0 or higher**

Have a problem with this extension?  [Log an Issue](https://github.com/blackberry/WebWorks-Community-APIs/issues) or contact the [Author](https://github.com/mdwhite76)

## How To Configure The Extension For Use

1. Locate your BlackBerry WebWorks SDK for Smartphone extensions directory using your File Explorer.  Default path is _**C:\Program Files\Research In Motion\BlackBerry WebWorks Packager\ext**_

2. Create a new _**webworks.phone**_ directory in the _**ext**_ directory

3. Download the source from this repository and unzip it to a location on your computer

4. Using File Explorer browse to this extension's downloaded source code _**webworks\phone**_

5. Copy the _**library.xml**_ file from the downloaded _**webworks\phone**_ directory to your new _**ext\webworks.phone**_ directory

6. Copy the downloaded _**webworks\phone**_ directory to your new _**ext\webworks\phone**_ directory

**NOTE:** Be sure to back-up this _**ext\webworks\phone**_ directory in your WebWorks SDK extensions directory before performing a WebWorks SDK upgrade. Simply copy it back into the _**ext**_ directory after you have completed your SDK upgrade.

## Required Feature ID
Whenever you use the below feature id in any of your WebWorks applications this extension will be loaded for use.

    <feature id="webworks.phone" />

## Summary

	webworks.phone.startListening(onEvent: function); 
	webworks.phone.stopListening(); 

## Usage Informaton
When an application starts, start your listener and define what function to call when a phone call occurs
   
## Code Example

    function startPhoneListener() {
      try {
            //call startListening passing the callback function
            webworks.phone.startListening(displayMessage); //there’s also a “stopListening”
            
      } catch (err) {
            document.getElementById('debug_area').innerHTML += "<br>error starting listener " + err;
      }
}

function displayMessage(phoneObject){
      try {
            document.getElementById('debug_area').innerHTML += "<br>phoneno: " + phoneObject.phoneno;
            document.getElementById('debug_area').innerHTML += "<br>isoutgoing: " + phoneObject.isoutgoing;
            document.getElementById('debug_area').innerHTML += "<br>displayphoneno: " + phoneObject.displayphoneno;
            document.getElementById('debug_area').innerHTML += "<br>displayphoneevent: " + phoneObject.phoneevent;
      }
      catch (err){
            document.getElementById('debug_area').innerHTML += "<br>error in displayMessage " + err;
      }
}


## Disclaimer

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.