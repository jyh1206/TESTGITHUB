package goodtest



import grails.test.mixin.*
import spock.lang.*

@TestFor(NoHasManyController)
@Mock(NoHasMany)
class NoHasManyControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.noHasManyInstanceList
            model.noHasManyInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.noHasManyInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def noHasMany = new NoHasMany()
            noHasMany.validate()
            controller.save(noHasMany)

        then:"The create view is rendered again with the correct model"
            model.noHasManyInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            noHasMany = new NoHasMany(params)

            controller.save(noHasMany)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/noHasMany/show/1'
            controller.flash.message != null
            NoHasMany.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def noHasMany = new NoHasMany(params)
            controller.show(noHasMany)

        then:"A model is populated containing the domain instance"
            model.noHasManyInstance == noHasMany
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def noHasMany = new NoHasMany(params)
            controller.edit(noHasMany)

        then:"A model is populated containing the domain instance"
            model.noHasManyInstance == noHasMany
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/noHasMany/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def noHasMany = new NoHasMany()
            noHasMany.validate()
            controller.update(noHasMany)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.noHasManyInstance == noHasMany

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            noHasMany = new NoHasMany(params).save(flush: true)
            controller.update(noHasMany)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/noHasMany/show/$noHasMany.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/noHasMany/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def noHasMany = new NoHasMany(params).save(flush: true)

        then:"It exists"
            NoHasMany.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(noHasMany)

        then:"The instance is deleted"
            NoHasMany.count() == 0
            response.redirectedUrl == '/noHasMany/index'
            flash.message != null
    }
}
