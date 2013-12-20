package goodtest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import goodtest.*;

@Transactional(readOnly = true)
class NoHasManyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NoHasMany.list(params), model:[noHasManyInstanceCount: NoHasMany.count()]
    }
	
	//add
	def testNoHasMany(NoHasMany noHasMany) {
		//noHasMany.save(flush : true)
		
		// validation 체크
		//if (noHasMany.hasErrors()) {
		//	return render (view : 'add', model : [noHasMany : noHasMany])
		//}
		redirect(action : "add_OK")
	}
	
	def add(){
		new NoHasMany(testGe:"Jung").save(failOnError:true);
		new NoHasMany(testGe:"Kim").save(failOnError:true);
		new NoHasMany(testGe:"Lee").save(failOnError:true);
		System.out.println("save");
	}
	
	def complete(){
	
	}

    def show(NoHasMany noHasManyInstance) {
        respond noHasManyInstance
    }

    def create() {
        respond new NoHasMany(params)
    }

    @Transactional
    def save(NoHasMany noHasManyInstance) {
        if (noHasManyInstance == null) {
            notFound()
            return
        }

        if (noHasManyInstance.hasErrors()) {
            respond noHasManyInstance.errors, view:'create'
            return
        }

        noHasManyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'noHasManyInstance.label', default: 'NoHasMany'), noHasManyInstance.id])
                redirect noHasManyInstance
            }
            '*' { respond noHasManyInstance, [status: CREATED] }
        }
    }

    def edit(NoHasMany noHasManyInstance) {
        respond noHasManyInstance
    }

    @Transactional
    def update(NoHasMany noHasManyInstance) {
        if (noHasManyInstance == null) {
            notFound()
            return
        }

        if (noHasManyInstance.hasErrors()) {
            respond noHasManyInstance.errors, view:'edit'
            return
        }

        noHasManyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'NoHasMany.label', default: 'NoHasMany'), noHasManyInstance.id])
                redirect noHasManyInstance
            }
            '*'{ respond noHasManyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(NoHasMany noHasManyInstance) {

        if (noHasManyInstance == null) {
            notFound()
            return
        }

        noHasManyInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'NoHasMany.label', default: 'NoHasMany'), noHasManyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'noHasManyInstance.label', default: 'NoHasMany'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
