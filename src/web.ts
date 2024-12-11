import { WebPlugin } from '@capacitor/core';

import type { ForegroundPluginPlugin } from './definitions';

export class ForegroundPluginWeb extends WebPlugin implements ForegroundPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
