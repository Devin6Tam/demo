package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

/**
 * 扩展命令
 *
 * @author tanxw
 * @date 2019/6/26
 */
class hello {

    @Usage("Say hello")
    @Command
    def main(InvocationContext context){
        def bootVersion = context.attributes['spring.boot.version'];
        def springVersion = context.attributes['spring.version'];
        return "Hello,your boot version is "+bootVersion+",and your spring version is "+springVersion;
    }
}
