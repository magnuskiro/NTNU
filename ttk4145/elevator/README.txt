Warning: This worked in 2009, and is not updated since then.

The comedi-file might need to be recompiled to work, and the "device"-field in IO.py might need to be changed from '/dev/comedi0' to the proper device.

Lines 5-14 in "driver.py" is added to stop the elevator when Ctrl-C is pressed, but this feature might cause problems with initial testing.

Good Luck!

Driver written by Sigurd Mørkved Albrektsen and Ulrich Myhre in 2009.