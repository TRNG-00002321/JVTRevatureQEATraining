# Originally created: 11/06/2025
# Version: 1.0

import logging
logging.basicConfig(filename="mylog.log", level=logging.WARNING,
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

logging.info("This is an info message")
logging.debug("This is a debug message")
logging.warning("This is an warning message")
logging.error("This is an error message")
logging.critical("This is critical message")