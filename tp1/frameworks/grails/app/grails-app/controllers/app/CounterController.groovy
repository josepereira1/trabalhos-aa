package app

class CounterController {

	int value = 0

	/* standard method */
    def index() { 
    	render "Standard method!"
    }

    /* increment value */
    def increment(){
    	this.value++
    	display()
    }

    /* decrement value */
    def decrement(){
    	this.value--
    	display()
    }

    /* display value */
    def display(){
		render "value = " + this.value
    }

    /* set value */
    def set(int value){
    	this.value = value
    	display()
    }
}
